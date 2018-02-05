package tma.mongodb.update;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import tma.mongodb.ConnectDB;
import tma.mongodb.CreateDB;

public class CreateData {
	public static void main(String[] args) throws UnknownHostException{
		//Connect toi mongodb
				MongoClient mongoClientpdhoang = ConnectDB.getmongoClientpdhoang();
				//Ket noi toi database
				DB dbpdhoang = mongoClientpdhoang.getDB(CreateDB.DB_NAME);
				//Lay ra ten collection can lay
				DBCollection city = dbpdhoang.getCollection("City_New_5");
				
				String[] cityVT = new String[]{"SG","HN","DL"};
				String[] cityNames = new String[]{"saigon","hanoi","dalat"};
				int[] nhietdo = new int[]{20,21,19};
				String[] giaothong = new String[]{"binhthuong",null,"tot"};
				for(int i=0;i<3;i++){
					BasicDBObject doc = new BasicDBObject();
					doc.append("_id", i*10);
					doc.append("cityVT",cityVT[i]);
					doc.append("cityNames", cityNames[i]);
					doc.append("nhietdo",nhietdo[i]);
					if(giaothong != null){
						doc.append("giaothong",giaothong[i]);
					}
					
					city.insert(doc);
				}
				
				BasicDBObject doc2 = new BasicDBObject();
				doc2.append("_id", 200);
				doc2.append("user_name","user2");
				doc2.append("passworld", 123456);
				doc2.append("location", "HaNoi");
				city.insert(doc2);
				
				BasicDBObject doc3 = new BasicDBObject();
				doc3.append("_id", 300);
				doc3.append("user_name","user3");
				doc3.append("passworld", 123456);
				doc3.append("location", "DaLat");
				city.insert(doc3);
			System.out.println("done!");
	}

}
