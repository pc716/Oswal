package com.oswal.backend.controller;

import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;


public class DatabaseClient {

    private MongoClient mongo_client;

    public DatabaseClient(){
        mongo_client = new MongoClient("localhost", 27017);
    }
}
