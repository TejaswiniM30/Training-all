package com.training;

import java.util.HashMap;
import java.util.Map;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

public class WriteToCollection {

	public static void main(String[] args) {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB db = mongoClient.getDB("exdb");
		DBCollection dbc = db.getCollection("emps1");

		//first way
//		DBObject document = new BasicDBObject();
//		document.put("empid", 400);
//		document.put("empname", "abc");
//		document.put("empemail", "abc@exilant.com");
	//	dbc.save(document);
	//	System.out.println("object inserted 1");

		
		
		
		
		
		
		
		
		
		//second way
//		Map<String, Object> map = new HashMap<>();
//		map.put("empid", 302);
//		map.put("empname", "Rupa");
//		map.put("email", "rupa@gmail.com");
//		map.put("empsal", 30000);
//		dbc.save(new BasicDBObject(map));
//		System.out.println("Object saved");
		
		
		//third way
		
	//	String jsonString = "{empid:303,empname:'sid', empemail:'sid@yahoo.com', empsal:30000}";
	//	dbc.save((DBObject) JSON.parse(jsonString));
	//	System.out.println("Object 3 saved");
	
		//fourth way -- store the bean directly
		Employee employee = new Employee();
		employee.setEmpId(999);
		employee.setEmpEmail("zys@exilant.com");
		employee.setEmpName("zys");
		employee.setEmpSal("300000");
		dbc.save((DBObject)employee);
		System.out.println("Object saved");
		
		
		
	}

}
