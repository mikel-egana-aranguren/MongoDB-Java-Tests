package org.biocrucesbizkaia.bioinformatics.mongodb;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;

public class Exec {

	public static void main(String[] args) {
		try {
			MongoClient mongoClient = new MongoClient();
			DB db = mongoClient.getDB( "JavaTests" );
			System.out.println(db.collectionExists("JavaCollection"));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
