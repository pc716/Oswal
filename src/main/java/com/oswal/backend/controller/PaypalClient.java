package com.oswal.backend.controller;

import com.paypal.base.rest.APIContext;

public class PaypalClient {

    private static String client_id = "AUxbkPsELaJ3lZfpuO4QjbxPbXLbP5XErB3oDr4NuLZkSuqFkwpqhVJPiH0fsTIZzKr-t3T1kzpUCbtC";
    private static String client_secret = "ELUEEDIlXssTUIpYpj_2SJ-kAfLZXliJs3Tul7OPOq2uXgQEm-Yp9vBEWj4s-7x_9kyH0KdOyTwxhQA4";
    private static APIContext api_context;

    public PaypalClient(){
        api_context = new APIContext(client_id,client_secret,"sandbox");
    }

    public PaymentClient create_payment_client(){
        return new PaymentClient(api_context);
    }

    public PayoutClient create_payout_client() { return new PayoutClient(api_context); }
}