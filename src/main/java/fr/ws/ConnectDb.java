package fr.ws;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class ConnectDb {

    private static ConnectDb connectDb;
    private DB dbConnection = null;

    private ConnectDb() {
        // Private constructor to avoid instantiate singleton
    }

    public static ConnectDb getInstance() {
        if (connectDb == null) {
            connectDb = new ConnectDb();
        }
        return connectDb;
    }

    private DB connectToDB() {
        if (dbConnection == null) {
            MongoClient mongo = new MongoClient( "127.0.0.1" , 27017 );
            dbConnection = mongo.getDB("mydb");
        }
        return dbConnection;
    }

    public DBCollection getCollection(String name) {
        return connectToDB().getCollection(name);
    }

}
