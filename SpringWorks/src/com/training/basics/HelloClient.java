package com.training.basics;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class HelloClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("spring-context.xml"));
		ApplicationContext factory = new ClassPathXmlApplicationContext("spring-context.xml");
		HelloService helloService = (HelloService) factory.getBean("defaultHello");
		
		System.out.println(helloService.sayHello());
		
	}

}
