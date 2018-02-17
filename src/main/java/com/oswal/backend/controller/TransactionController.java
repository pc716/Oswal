package com.oswal.backend.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.paypal.api.payments.Payment;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import org.json.*;
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
/*
    @RequestMapping("/finalize_transaction/{recipient}", method = RequestMethod.POST)
    public ResponseEntity<?> finalize_transaction(@PathVariable("recipient") String recipient){

    }
*/
}