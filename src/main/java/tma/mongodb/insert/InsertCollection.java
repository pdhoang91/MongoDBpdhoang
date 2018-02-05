package tma.mongodb.insert;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import tma.mongodb.ConnectDB;
import tma.mongodb.CreateDB;

public class InsertCollection {
	public static void main(String[] args) throws UnknownHostException{
		//Connect toi mongodb
		MongoClient mongoClientpdhoang = ConnectDB.getmongoClientpdhoang();
		//Ket noi toi database
		DB dbpdhoang = mongoClientpdhoang.getDB(CreateDB.DB_NAME);
		//Lay ra ten collection can lay
		DBCollection temp = dbpdhoang.getCollection("USERS4");
		
		BasicDBObject doc1 = new BasicDBObject();
		doc1.append("_id", 10);
		doc1.append("user_name","user1");
		doc1.append("passworld", 123456);
		doc1.append("location", "SaiGon");
		temp.insert(doc1);
		
		BasicDBObject doc2 = new BasicDBObject();
		doc2.append("_id", 20);
		doc2.append("user_name","user2");
		doc2.append("passworld", 123456);
		doc2.append("location", "HaNoi");
		temp.insert(doc2);
		
		BasicDBObject doc3 = new BasicDBObject();
		doc3.append("_id", 30);
		doc3.append("user_name","user3");
		doc3.append("passworld", 123456);
		doc3.append("location", "DaLat");
		temp.insert(doc3);
	System.out.println("done!");
	}
}
