package com.oswal.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoginController {

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public ResponseEntity<?> start_transaction(@RequestBody Map<String,Object> map) {
        boolean valid = false;

        System.out.println(map);
        String email = (String) map.get("email");
        String password = (String) map.get("password");

        DatabaseClient db_client = new DatabaseClient();
        valid = db_client.checkUser(email,password);


        String response = "{ 'valid' : '" + valid + "'}";

        return new ResponseEntity<String>(response , HttpStatus.OK);
    }
}
