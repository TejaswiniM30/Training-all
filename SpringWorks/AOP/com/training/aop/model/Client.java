package com.training.aop.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("aop-context.xml");
		BankingService service = (BankingService) context.getBean("banking");

		System.out.println(service.getSbAccount().getAcc().getBalance());

		System.out.println("after advice for sb account should be invoked");

		System.out.println(service.getCaAccount().getAcc().getBalance());

		System.out.println("after advice for ca account should not be invoked");

		// System.out.println(service.getSbAccount().getAcc());

		System.out.println("-----show balance of ca account called-------");

		System.out.println(service.getCaAccount().showBalance());

		System.out.println("----------show balance of sb account-------");
		System.out.println(service.getSbAccount().showBalance());
		// service.getCaAccount().getOneParameter(100);
		
		String retVal = service.setAndGet("Harry");
		System.out.println("Return val in main: "+retVal);
		
		service.throwSomeException();

	}

}
