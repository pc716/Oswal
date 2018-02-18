package com.oswal.backend.controller;

import com.paypal.api.payments.Payout;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class CheckCashController {

    @RequestMapping(value="/cash_check", method=RequestMethod.PUT)
    public ResponseEntity<?> cash_check(@RequestBody Map<String,Object> map){
        String email = (String) map.get("email");
        String amount = (String) map.get("amount");

        PaypalClient paypal_client = new PaypalClient();
        PayoutClient payout_client = paypal_client.create_payout_client();
        Payout payout = payout_client.create_payout(email, amount);

        DatabaseClient dbc = new DatabaseClient();
        dbc.add_user_balance(amount);

        return new ResponseEntity<String>("{ result : success", HttpStatus.OK);
    }
}
