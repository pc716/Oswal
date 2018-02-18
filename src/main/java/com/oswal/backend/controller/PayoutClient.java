package com.oswal.backend.controller;


import com.paypal.api.payments.Payout;
import com.paypal.base.rest.*;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;


public class PayoutClient {

    private APIContext context;
    private Payout payout;

    public PayoutClient(APIContext context){
        this.context = context;
    }






}
