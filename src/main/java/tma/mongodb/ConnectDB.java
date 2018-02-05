package tma.mongodb;

//import java.util.List;
import java.net.UnknownHostException;

import com.mongodb.MongoClient;

public class ConnectDB {
	
	private static final String HOST="localhost";
	private static final int PORT = 27017;
	
	private static MongoClient getmongoClientHP() throws UnknownHostException{
		MongoClient mongoClientHP = new MongoClient(HOST, PORT);
		return mongoClientHP;
	}
	
	public static MongoClient getmongoClientpdhoang() throws UnknownHostException{
		return getmongoClientHP();
	}
	
//	private static void pingDB() throws UnknownHostException{
//		MongoClient mongoClientHP = getmongoClientHP();
//		System.out.println("List all DB");
//		List<String> dbnames = mongoClientHP.getDatabaseNames();
//		for(String dbName : dbnames){
//			System.out.println(" DB Name: " + dbName);
//		}
//	}
	public static void main(String[] args) throws UnknownHostException{
		//pingDB();
		System.out.println("done!");
	}
}
