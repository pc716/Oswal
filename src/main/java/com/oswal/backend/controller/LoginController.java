package com.oswal.backend.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonObject;
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

import java.util.Map;

@RestController
public class LoginController {

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public ResponseEntity<?> start_transaction(@RequestBody Map<String,Object> map) {
        boolean valid = false;

        System.out.println(map);
        String email = (String) map.get("email");
        String password = (String) map.get("password");

        valid = true; //if in database


        String response = "{ 'valid' : '" + valid + "'}";

        return new ResponseEntity<String>(response , HttpStatus.OK);
    }





}
