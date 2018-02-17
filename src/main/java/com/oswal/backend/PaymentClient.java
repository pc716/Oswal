package com.oswal.backend;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

import java.util.*;

public class PaymentClient {
    private APIContext context;
    public PaymentClient(APIContext context){
        this.context = context;
    }


    public String create_payment(String amount){
        Payment payment_object = initialize_payment_object(amount);
        try {
            Payment created_payment = payment_object.create(context);
            return created_payment.getId();
        }
        catch(PayPalRESTException e){
            System.out.println(e);
        }

        return null;
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
