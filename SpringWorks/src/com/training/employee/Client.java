package com.training.employee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.basics.HelloService;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ApplicationContext context = new ClassPathXmlApplicationContext("spring-context2.xml");
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-context2.xml","spring-context.xml");
		Employee employee1 = context.getBean("employee",Employee.class);
		System.out.println(employee1.hashCode());
		System.out.println("Emp id "+employee1.getEmpId());
		System.out.println("Emp name "+employee1.getEmpName());
		System.out.println("Emp sal "+employee1.getEmpSal());
		System.out.println("Details "+employee1);
		
		Employee employee2 = context.getBean("employee",Employee.class);
		System.out.println(employee2.hashCode());
		System.out.println("Emp id "+employee2.getEmpId());
		System.out.println("Emp name "+employee2.getEmpName());
		System.out.println("Emp sal "+employee2.getEmpSal());
		System.out.println("Details "+employee2);
		//destroy method will not be invoked since the life cycle control is with us and not spring as the scope is prototype
		//so this method will be invoked only when the scope of the bean is singleton
		
		HelloService service = (HelloService) context.getBean("defaultHello");
		System.out.println(service.sayHello());
		context.registerShutdownHook();
	}

}
