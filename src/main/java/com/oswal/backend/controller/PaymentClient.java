package com.oswal.backend.controller;

import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

import java.util.*;

public class PaymentClient {

    private APIContext context;
    private Payment payment_object;

    public PaymentClient(APIContext context){
        this.context = context;
    }

    public Payment create_payment(String amount){
        payment_object = initialize_payment_object(amount);
        try {
            payment_object = payment_object.create(context);
            return payment_object;
        }
        catch(PayPalRESTException e){
            System.out.println(e.getCause() + "\n" + e.getCause());
        }

        return null;
    }

    public void execute_payment(String payer_id){
        PaymentExecution execute = new PaymentExecution();
        execute.setPayerId(payer_id);
        try {
            payment_object.execute(context, execute);
        }
        catch(PayPalRESTException e){
            System.out.println(e.getCause() + "\n" + e.getCause());
        }
    }

    public Payment initialize_payment_object(String amount){
        Amount payment_amount = initialize_amount(amount);

        Payment payment_object = new Payment();
        payment_object.setIntent("sale");
        payment_object.setPayer(initialize_payer());
        payment_object.setTransactions(initialize_transaction(payment_amount));
        payment_object.setRedirectUrls(initialize_redirect_urls());

        return payment_object;
    }

    public List<Transaction> initialize_transaction(Amount amount){
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);

        return new ArrayList<Transaction>() {{ add(transaction); }};
    }

    public Amount initialize_amount(String amount){
        return new Amount("USD", amount);
    }

    public Payer initialize_payer(){
        Payer payer = new Payer();
        payer.setPaymentMethod("paypal");

        return payer;
    }

    public RedirectUrls initialize_redirect_urls(){
        RedirectUrls urls = new RedirectUrls();
        urls.setCancelUrl("https://example.com/cancel");
        urls.setReturnUrl("https://example.com/return");

        return urls;
    }
}
