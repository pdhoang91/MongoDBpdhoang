package tma.mongodb.collection;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import tma.mongodb.ConnectDB;
import tma.mongodb.CreateDB;

public class ShowCollection {

	public static void main(String[] args) throws UnknownHostException{
		MongoClient mongoClientHP = ConnectDB.getmongoClientpdhoang();
		DB db = mongoClientHP.getDB(CreateDB.DB_NAME);
		
		DBCollection temp = db.getCollection("USERS");
		System.out.println("Collection: " + temp);
		
		long rowCount = temp.count();
		System.out.println("Document count: " + rowCount);
		System.out.println("----------------------");
		
		Set<String> collections =  db.getCollectionNames();
		for(String collection : collections){
			System.out.println(" Collection: " + collection);
		}
		
	}
}

//==========================Dang bi loi