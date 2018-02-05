package tma.mongodb.query;

import java.net.UnknownHostException;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

import tma.mongodb.ConnectDB;
import tma.mongodb.CreateDB;

public class TruyVan1 {
	public static void main(String[] args) throws UnknownHostException{
		//Ket noi toi mongoDB
		MongoClient mongoClient = ConnectDB.getmongoClientpdhoang();
		DB db = mongoClient.getDB(CreateDB.DB_NAME);
		DBCollection temp = db.getCollection("USERS");
		
		//truy van tat ca cac object trong collection
		DBCursor cursor = temp.find();
		
		while(cursor.hasNext()){
			System.out.print("Document: ");
			System.out.println(cursor.next());
		}
	}		 
}
