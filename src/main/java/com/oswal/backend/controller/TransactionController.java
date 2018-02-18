package com.oswal.backend.controller;

import com.paypal.api.payments.Payment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @RequestMapping(value = "/start_transaction", method = RequestMethod.POST)
    public ResponseEntity<?> start_transaction(@RequestBody Payment payment) {

        String amount = payment.getTransactions().get((0)).getAmount().getTotal();
        PaypalClient paypal_client = new PaypalClient();
        PaymentClient payment_client = paypal_client.create_payment_client();
        Payment created_payment = payment_client.create_payment(amount);

        return new ResponseEntity<String>(created_payment.toString(), HttpStatus.OK);
    }

    @RequestMapping(value = "/finalize_transaction/{recipient}/{amount}", method = RequestMethod.POST)
    public ResponseEntity<?> finalize_transaction(@RequestBody Map<String, Object> map,
                                                  @PathVariable("recipient") String recipient,
                                                  @PathVariable("amount") String amount) {

        String execute_url = (String) map.get("url");

        PaypalClient paypal_client = new PaypalClient();
        PaymentClient payment_client = paypal_client.create_payment_client();
        payment_client.execute_payment(get_payer_id(execute_url));

        PayoutClient payout_client = paypal_client.create_payout_client();
        payout_client.create_payout(recipient, amount);

        return null;
    }

    public String get_payer_id(String execute_url) {
        int idx = execute_url.indexOf("PAYER_ID");
        return execute_url.substring(idx);
    }

}