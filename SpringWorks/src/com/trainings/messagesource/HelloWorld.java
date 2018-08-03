package com.trainings.messagesource;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

public class HelloWorld {
	private String greeting;
	private String message;
	
	
	
	
	//you can have messageResource entry made in .xml file and you can do autowire or do as shown below
	@Autowired
	private MessageSource messageSource;


	public String getGreeting() {
		return greeting;
	}


	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public MessageSource getMessageSource() {
		return messageSource;
	}


	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	//the values shall be injected
	public void sayHelloWorld() {
		System.out.println(messageSource.getMessage("helloworld.greet", new Object[] {greeting, message}, null));
	}
	
	public void sayHelloWorld_fr() {
		System.out.println(messageSource.getMessage("helloworld.greet", new Object[] {greeting, message}, new Locale("frn")));
	}
	
	public void sayHelloWorld_jap() {
		System.out.println(messageSource.getMessage("helloworld.greet", new Object[] {greeting,message}, new Locale("Jap")));
	}
	
	
}
