package com.exilant.day1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaSort05 {

	public static void main(String[] args) {
		List<Customer> customers = Arrays.asList(new Customer(101, "john", 4000, "Engineer"),
				new Customer(102, "david", 9000, "Analyst"), new Customer(103, "kavya", 10000, "Tester"),
				new Customer(104, "Rama", 6000, "Devops"), new Customer(105, "Radika", 2000, "Sr dev"));
		System.out.println("------Before Sort------");
		customers.forEach(System.out::println);

		// jdk 1.7 or older syntax
		Collections.sort(customers, new Comparator<Customer>() {
			public int compare(Customer c1, Customer c2) {
				return c1.getCustomerName().compareTo(c2.getCustomerName());
			}
		});
		System.out.println("------After sort--------");
		customers.forEach(System.out::println);

		// jdk 1.8
		System.out.println("-----sort using lambda-----");
		customers.sort((a, b) -> (int) (a.getCustomerPurchase() - b.getCustomerPurchase()));
		customers.forEach(System.out::println);

		
		System.out.println("----sort using name--------");
		Collections.sort(customers, (c1, c2) -> c1.getCustomerName().compareTo(c2.getCustomerName()));
		customers.forEach(System.out::println);
		
		System.out.println("-----sort using designation------");
		Comparator<Customer> asc_comp = (a, b) -> a.getDesignation().compareTo(b.getDesignation());
		customers.sort(asc_comp);
		customers.forEach(System.out::println);
		System.out.println("------comparator reversed------");
		customers.sort(asc_comp.reversed());
		customers.forEach(System.out::println);
		
	}

}
