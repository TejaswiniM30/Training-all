package com.exilant.day1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Comparing01 {

	public static void main(String[] args) {
		List<Customer> customers = Arrays.asList(new Customer(101, "john", 4000, "Engineer"),
				new Customer(102, "john", 4000, "Systems analyst"),
				new Customer(103, "david", 9000, "Analyst"), new Customer(104, "kavya", 10000, "Tester"),
				new Customer(105, "Rama", 6000, "Devops"), new Customer(106, "Radika", 2000, "Sr dev"),
				new Customer(107, "john", 4000, "Sr Tester"),
				new Customer(108, "david", 10000, "Engineer"),
				new Customer(109, "david", 15000, "Engineer"));
		
		Comparator<Customer> new_comp = Comparator.comparing(Customer :: getCustomerName).thenComparing(Customer :: getCustomerPurchase).thenComparing(Customer :: getDesignation);
		Collections.sort(customers, new_comp);
		customers.forEach(System.out::println);
		
	}

}
