package com.trainings.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
 public static void main(String[] args) {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	context.getEnvironment().setActiveProfiles("Development");

	
	//scans the mentioned package[s] and register all the components available in the spring
	
	context.scan("com.trainings.profile");
	context.refresh();
	context.close();
}
}
