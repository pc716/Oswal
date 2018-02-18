package com.oswal.backend.controller;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;


public class DatabaseClient {

    private MongoClient mongo_client;
    private MongoDatabase database;

    public DatabaseClient(){
        mongo_client = new MongoClient("localhost", 27017);
        database = mongo_client.getDatabase("database");

    }

    public boolean checkUser(String email,String password){
        try {
            boolean found_user;
            BasicDBObject obj = new BasicDBObject("email", email);
            obj.put("password", password);
            boolean x = database.getCollection("users").find(obj).first().containsValue(email);
        }
        catch(Exception e){
            System.out.println(e.getCause() + e.getMessage());
        }
        return true;
    }





}
