package tma.mongodb.query;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import tma.mongodb.ConnectDB;
import tma.mongodb.CreateDB;

public class TruyVan2 {
	  // Xây dựng JSON:
	   // { "dept_name" : "ACCOUNTING"}
	private static DBObject getWhereHP(){
		BasicDBObjectBuilder wherebuider = BasicDBObjectBuilder.start();
		wherebuider.append("location", "HaNoi");
		DBObject where = wherebuider.get();
		System.out.println("Where: " + where.toString());
		return where;
	}
	
	public static void main(String[] args) throws UnknownHostException{
		//Ket noi toi mongoDB
		MongoClient mongoClient = ConnectDB.getmongoClientpdhoang();
		DB db = mongoClient.getDB(CreateDB.DB_NAME);
		DBCollection temp = db.getCollection("USERS");
		
		DBObject where_query = getWhereHP();
		//truy van tat ca cac object trong collection
		DBCursor cursor = temp.find(where_query);
		
		while(cursor.hasNext()){
			System.out.print("Document: ");
			System.out.println(cursor.next());
		}
	}
}
