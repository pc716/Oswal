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

import java.util.Map;


@RestController
public class CheckCashController {

    @RequestMapping(value="/cash_check", method=RequestMethod.PUT)
    public ResponseEntity<?> cash_check(@RequestBody Map<String,Object> map){

    }


}