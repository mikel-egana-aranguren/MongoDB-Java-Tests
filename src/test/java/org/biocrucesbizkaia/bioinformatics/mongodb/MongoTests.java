package org.biocrucesbizkaia.bioinformatics.mongodb;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

public class MongoTests {
	
	private static final Logger LOGGER = LogManager.getLogger(MongoTests.class);
	
	private final static String dbName = "JavaTests";
	private final static String collectionName = "BigCollection";
	private static MongoClient client;
	private static MongoDatabase db;
	private static MongoCollection coll;

	@BeforeClass
    public static void setUpBeforeClass() {
		client = new MongoClient();
		db = client.getDatabase(dbName);
		coll = db.getCollection(collectionName);
	}
	
	@Test
	public final void getClient() {
		assertNotNull(client);
	}
	
	@Test
	public final void getDB() {
		assertNotNull(db);
	}
	
	@Test
	public final void getCollection() {
		assertNotNull(coll);
	}
	
	@Test
	public final void insertBulkDocs() {
		int i = 0;
		while (i < 75000) {
			i+=1;
			Document doc = new Document("name", "MongoDB")
			        .append("type", "database")
			        .append("count", i)
			        .append("info", new Document("x", 203).append("y", 102));
			LOGGER.info(doc.toJson());
			coll.insertOne(doc);
		}
		assertEquals(75000, coll.count(new Document()));
	}
			
	@AfterClass
	public static void tearDownAfterClass() {
		coll.deleteMany(new Document());
		client.close();
	}
}
