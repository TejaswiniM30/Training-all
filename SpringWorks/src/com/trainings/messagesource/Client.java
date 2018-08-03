package com.trainings.messagesource;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("message-resource-context.xml");
		String engGoodMorning = context.getMessage("goodmorning", new Object[] {}, null);
		String frGoodMorning = context.getMessage("goodmorning", new Object[] {}, new Locale("FRN"));
		String jpGoodMorning = context.getMessage("goodmorning", new Object[] {}, new Locale("JAP"));
		System.out.println("Eng  :"+engGoodMorning);
		
		System.out.println("French :"+frGoodMorning);
		
		System.out.println("Japanese :"+jpGoodMorning);

		System.out.println("--------------------------------------------");

		HelloWorld helloWorld = context.getBean("helloWorld", HelloWorld.class);
		helloWorld.sayHelloWorld();
		helloWorld.sayHelloWorld_fr();
		helloWorld.sayHelloWorld_jap();
	}

}
