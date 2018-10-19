package org.biocrucesbizkaia.bioinformatics.mongodb;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;

public class Exec {

	public static void main(String[] args) {
		try {
			MongoClient mongoClient = new MongoClient();
			DB db = mongoClient.getDB( "JavaTests" );
//			System.out.println("JavaCollection exists: " + db.collectionExists("JavaCollection"));
//			DBCollection coll = db.getCollection("JavaCollection");
			DBCollection coll = db.getCollection("BigCollection");
			
			int i = 0;
			
			while (i < 75000) {
				i+=1;
				System.out.println(i);
				BasicDBObject doc = new BasicDBObject("name", "MongoDB")
				        .append("type", "database")
				        .append("count", i)
				        .append("info", new BasicDBObject("x", 203).append("y", 102));
				coll.insert(doc);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
