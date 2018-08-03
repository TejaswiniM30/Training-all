package com.training;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class GetAllRecords {

	public static void main(String[] args) {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB db = mongoClient.getDB("exdb");
		DBCollection dbc = db.getCollection("emps");
		DBCursor cursor = dbc.find();
		
		while(cursor.hasNext()) {
			DBObject object = cursor.next();
			System.out.println("Employee ID "+object.get("empid"));
			System.out.println("Employee Name "+object.get("empname"));
			System.out.println("Employee Email "+object.get("empemail"));
			System.out.println("-------------------------------------------");

		}
		
	}

}
