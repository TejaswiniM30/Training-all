package com.exilant.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.exilant.day1.Customer;

public class CustomerFiltering {

	public static void main(String[] args) {
		List<Customer> customers = Arrays.asList(new Customer(101, "john", 4000, "Engineer"),
				new Customer(102, "david", 9000, "Analyst"), new Customer(103, "kavya", 10000, "Tester"),
				new Customer(104, "Rama", 6000, "Devops"), new Customer(105, "Radika", 2000, "Sr dev"), new Customer(106, "Pooja", 40000, "Manager"),new Customer(107, "Rachana", 1000, "Tester") );
		
		Predicate<Customer> greaterThan6k_tester  = customer -> customer.getCustomerPurchase()>=6000 && customer.getDesignation()=="Tester";
//		Predicate<Customer> designation = customer -> customer.getDesignation()=="Tester";
//		Predicate<Customer> compound = greaterThan.and(designation);
		
		List<Customer> newList = filterCustomers(customers, Tester_6k());
		newList.forEach(System.out::println);
	}
	
	public static Predicate<Customer> Tester_6k(){
		return p -> p.getCustomerPurchase()>=6000 && p.getDesignation()=="Tester";
	}
	
	public static List<Customer> filterCustomers(List<Customer> customers, Predicate<Customer> check) {
//		List<Customer> newList = new ArrayList<Customer>();
//		for(Customer temp : customers) {
//			if(check.test(temp)) {
//				newList.add(temp);
//			}
//		}
//		return newList;
		return customers.stream().filter(check).collect(Collectors.toList());
			
	}

}
