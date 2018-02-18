package com.oswal.backend.controller;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class DatabaseClient {

    private static MongoClient mongo_client = new MongoClient("localhost", 27017);
    private static MongoDatabase database = mongo_client.getDatabase("database");

    public DatabaseClient(){

    }

    public boolean checkUser(String email,String password){
        boolean x = false;

        boolean found_user;
        BasicDBObject obj = new BasicDBObject("email", email);
        obj.put("password", password);
        MongoCollection collection = database.getCollection("users");
        x = null != collection.find(obj);

        return x;
    }

    public String get_user_balance(String email){
        MongoCollection collection = database.getCollection("users");
        Document d = (Document) collection.find(new BasicDBObject("email",email));
        return (String) d.get("balance");
    }

    public void add_user_balance(String email, String amount){
        MongoCollection collection = database.getCollection("users");
        Document d = (Document) collection.find(new BasicDBObject("email",email));
        double balance = Double.parseDouble((String) d.get("balance")) + Double.parseDouble(amount);
        collection.updateOne(new BasicDBObject("email",email), new BasicDBObject("email",email).append("balance",balance));
    }

}
