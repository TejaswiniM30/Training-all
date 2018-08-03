package com.training.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	ApplicationContext context = new ClassPathXmlApplicationContext("spring-context3.xml","camera-context.xml","screen-context.xml","speaker-context.xml");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-context3.xml");
		Mobile mobile = context.getBean("mobile", Mobile.class);
		System.out.println("Mobile details..");
		
		System.out.println("Camera type: "+mobile.getCamera().getType());
		System.out.println("Speaker details: "+mobile.getSpeaker().getType() +" "+mobile.getSpeaker().getVolLevels());
		System.out.println("Screen details: "+mobile.getScreen().getGlassType()+ " "+mobile.getScreen().getBre()+ " "+mobile.getScreen().getLen());
		
	}

}
