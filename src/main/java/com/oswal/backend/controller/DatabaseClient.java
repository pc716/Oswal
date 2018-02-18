package com.oswal.backend.controller;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;


public class DatabaseClient {

    private MongoClient mongo_client;
    private MongoDatabase database;

    public DatabaseClient(){
        mongo_client = new MongoClient("localhost", 27017);
        database = mongo_client.getDatabase("oswalDB");
        database.createCollection("users");
    }

    public boolean checkUser(String email,String password){
        boolean found_user;
        BasicDBObject obj = new BasicDBObject("email",email);
        obj.put("password", password);
        return database.getCollection("users").find(obj).first().containsValue(email);
    }





}
