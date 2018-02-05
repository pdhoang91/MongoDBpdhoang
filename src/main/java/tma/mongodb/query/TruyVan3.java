package tma.mongodb.query;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import tma.mongodb.ConnectDB;
import tma.mongodb.CreateDB;

public class TruyVan3 {
	  // Xây dựng JSON:
    
   // user_name in ('user1', 'user2') or location  = 'HaNoi'.
   // { "$or" : [ { "user_name" : { "$in" : [ "user1" , "user2"]}} , {"location" : "HaNoi"}]}
	private static DBObject getWhereHPso1(){
		 List<String> list = new ArrayList<String>();
		 list.add("user1");
		 list.add("user2");
		
		BasicDBObjectBuilder wherebuider01 = BasicDBObjectBuilder.start();
		wherebuider01.push("user_name").add("$in",list);
		DBObject clause1 = wherebuider01.get();
		
		BasicDBObjectBuilder wherebuider02 = BasicDBObjectBuilder.start();
		wherebuider02.append("location", "DaLat");
		DBObject clause2 = wherebuider02.get();
		
		BasicDBList or = new BasicDBList();
		or.add(clause1);
		or.add(clause2);
		
		BasicDBObjectBuilder buider = BasicDBObjectBuilder.start();
		buider.add("$or", or);
		DBObject query = buider.get();		
		System.out.println("query: " + query);
		return query;
	}
	
	public static void main(String[] args) throws UnknownHostException{
		//Ket noi toi mongoDB
		MongoClient mongoClient = ConnectDB.getmongoClientpdhoang();
		DB db = mongoClient.getDB(CreateDB.DB_NAME);
		DBCollection temp = db.getCollection("USERS");
		
		DBObject query = getWhereHPso1();
		//truy van toi query trong collection
		DBCursor cursor = temp.find(query);
		
		while(cursor.hasNext()){
			System.out.print("Document: ");
			System.out.println(cursor.next());
		}
		System.out.println("done!");
	}
}
