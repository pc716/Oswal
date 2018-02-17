package com.oswal.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @RequestMapping("/make_transaction/{recipient}/{amount}", method = RequestMethod.POST)
    public ResponseEntity<?> start_transaction(@PathVariable("recipient") String recipient,
                                              @PathVariable("amount") double amount){

    }

}
