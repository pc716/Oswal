package com.oswal.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @RequestMapping(value="/get_balance/{email}", method= RequestMethod.GET)
    public ResponseEntity<?> get_balance(@PathVariable String email){
        DatabaseClient dbc = new DatabaseClient();
        String amount = dbc.get_user_balance(email);

        return new ResponseEntity<String>("{ amount: " + amount + "}", HttpStatus.OK);
    }

}
