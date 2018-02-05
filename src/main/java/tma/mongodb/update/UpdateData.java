package tma.mongodb.update;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

import tma.mongodb.ConnectDB;
import tma.mongodb.CreateDB;

public class UpdateData {
	public static void main(String[] args) throws UnknownHostException{
		MongoClient mongoClient = ConnectDB.getmongoClientpdhoang();
		DB db = mongoClient.getDB(CreateDB.DB_NAME);
		DBCollection city = db.getCollection("City_New_5");
		
		DBObject whereClause = new BasicDBObject("cityVT", "HN");
		
		BasicDBObject values = new BasicDBObject();
		values.put("nhietdo", 21081991);
		values.put("note", "update with $set");
		
		DBObject valueswithSet = new BasicDBObject();
		valueswithSet.put("$set", values);
		
		WriteResult result = city.update(whereClause, valueswithSet);
		int effectedCount = result.getN();
		  System.out.println("Effected Count: " + effectedCount);
	      System.out.println("Done!");

		
	}
}
