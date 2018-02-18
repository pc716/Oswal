package com.oswal.backend.controller;

import com.paypal.api.payments.Payment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @RequestMapping(value="/start_transaction", method = RequestMethod.POST)
    public ResponseEntity<?> start_transaction(@RequestBody Payment payment) {
        try {
            String amount = payment.getTransactions().get((0)).getAmount().getTotal();
            PaypalClient paypal_client = new PaypalClient();
            PaymentClient payment_client = paypal_client.create_payment_client();
            Payment created_payment = payment_client.create_payment(amount);

            return new ResponseEntity<String>(created_payment.toString(), HttpStatus.OK);
        }
        catch(Exception e){
            System.out.println(e.getCause() + "\n" + e.getCause());
        }
        return null;
    }

    @RequestMapping(value="/finalize_transaction/{recipient}", method = RequestMethod.POST)
    public ResponseEntity<?> finalize_transaction(@RequestBody Map<String,Object> map, @PathVariable("recipient") String recipient){
        String execute_url = (String) map.get("url");
    }

}