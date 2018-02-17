package com.oswal.backend.controller;

import com.mongodb.DB;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import org.bson.Document;


public class DatabaseClient {

    private MongoClient mongo_client;
    private MongoDatabase database;

    public DatabaseClient(){
        mongo_client = new MongoClient("localhost", 27017);
        database = mongo_client.getDatabase("oswalDB");
        database.createCollection("users");
        Document doc = new Document("email" ,"djung8@gmu.edu").append("password", "123456");
        database.getCollection("users").insertOne(doc);
    }

    public boolean checkUser(String email,String password){
        database.getCollection("users").find( { email )
        return false;
    }





}
