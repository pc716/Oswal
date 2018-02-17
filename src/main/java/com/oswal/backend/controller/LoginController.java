package com.oswal.backend.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.paypal.api.payments.Payment;
import org.json.JSONException;
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

@RestController
public class LoginController {

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public ResponseEntity<?> start_transaction(@RequestBody JSONObject json) {
        boolean valid = false;
        try {
            String email = json.getString("email");
            String password = json.getString("password");

            valid = true; //if in database
        }
        catch(JSONException e){
            System.out.println(e);
        }

        String response = "{ 'valid' : '" + valid + "'}";

        return new ResponseEntity<String>(response , HttpStatus.OK);
    }





}
