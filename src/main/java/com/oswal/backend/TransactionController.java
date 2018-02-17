package com.oswal.backend;

import com.paypal.api.payments.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @ExceptionHandler(Throwable.class)
    public String handleAnyException(Throwable ex, HttpServletRequest request) {
        return ClassUtils.getShortName(ex.getClass());
    }

    @RequestMapping(value="/start_transaction", method = RequestMethod.POST)
    public ResponseEntity<?> start_transaction(@RequestBody JSONObject json){

        Payment payment = PaymentParser.parsed_payment(json);

        String amount = payment.getTransactions().get((0)).getAmount().getTotal();
        PaypalClient paypal_client = new PaypalClient();
        PaymentClient payment_client = paypal_client.create_payment_client();
        Payment created_payment = payment_client.create_payment(amount);

        return new ResponseEntity<Payment>(created_payment,HttpStatus.OK);
    }
/*
    @RequestMapping("/finalize_transaction/{recipient}", method = RequestMethod.POST)
    public ResponseEntity<?> finalize_transaction(@PathVariable("recipient") String recipient){

    }
*/
}
