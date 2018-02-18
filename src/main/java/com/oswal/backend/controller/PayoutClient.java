package com.oswal.backend.controller;


import com.paypal.api.payments.Currency;
import com.paypal.api.payments.Payout;
import com.paypal.api.payments.PayoutItem;
import com.paypal.api.payments.PayoutSenderBatchHeader;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

import java.util.ArrayList;
import java.util.List;


public class PayoutClient {

    private APIContext context;
    private Payout payout;


    public PayoutClient(APIContext context){
        this.context = context;
    }

    public Payout create_payout(String recipient, String amount){
        PayoutSenderBatchHeader batch_header = create_batch_header();
        List<PayoutItem> items = create_item_list(recipient, amount);
        payout.setSenderBatchHeader(batch_header);
        payout.setItems(items);
        try {
            payout.createSynchronous(context);
        }
        catch(PayPalRESTException e){
            System.out.println(e);
        }

        return payout;
    }

    public PayoutSenderBatchHeader create_batch_header(){
        PayoutSenderBatchHeader new_header = new PayoutSenderBatchHeader();
        new_header.setSenderBatchId(Math.random() * 1000000000 + "");
        return new_header;
    }

    public List<PayoutItem> create_item_list(String recipient, String amount){
        List<PayoutItem> list = new ArrayList<>();
        PayoutItem new_item = new PayoutItem();
        new_item.setAmount(new Currency().setValue(amount));
        new_item.setReceiver(recipient);
        new_item.setRecipientType("EMAIL");
        return list;
    }






}
