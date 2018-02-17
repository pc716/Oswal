package com.oswal.backend;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;

import java.util.ArrayList;
import java.util.List;

public class PaypalClient {

    private static String client_id = "AUxbkPsELaJ3lZfpuO4QjbxPbXLbP5XErB3oDr4NuLZkSuqFkwpqhVJPiH0fsTIZzKr-t3T1kzpUCbtC";
    private static String client_secret = "ELUEEDIlXssTUIpYpj_2SJ-kAfLZXliJs3Tul7OPOq2uXgQEm-Yp9vBEWj4s-7x_9kyH0KdOyTwxhQA4";
    private static APIContext api_context;

    public PaypalClient(){
        api_context = new APIContext(client_id,client_secret,"sandbox");
    }


}
