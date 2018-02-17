package com.oswal.backend;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;

import java.util.*;

public class PaymentClient {

    public void create_payment(String amount){
        Payment payment_object = initialize_payment_object(amount);
    }

    public Payment initialize_payment_object(String amount){
        Payment payment_object = new Payment();
        Amount payment_amount = initialize_amount(amount);
        List<Transaction> transactions = initialize_transaction(payment_amount);

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
}
