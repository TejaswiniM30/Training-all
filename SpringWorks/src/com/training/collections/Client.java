package com.training.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("collection-context.xml");
		MyCollection myCollection = context.getBean("myCollection", MyCollection.class);
		
		System.out.println(myCollection.getQuestionBank());
		System.out.println(myCollection.getAddressSet());
		System.out.println(myCollection.getAccountMap());
	}

}
