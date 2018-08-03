package com.exilant.day1;

//import java.awt.List;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
//to show working of map and filter based on the customer type
public class StreamMapEx02 {

	public static void main(String[] args) {
		List<Customer> customers = Arrays.asList(new Customer(101, "john", 4000, "Engineer"),
				new Customer(102, "david", 9000, "Analyst"), new Customer(103, "kavya", 10000, "Tester"),
				new Customer(104, "Rama", 6000, "Devops"),new Customer(105, "Radika", 2000, "Sr dev"));
		customers.forEach(System.out::println);
		List<PriorityCustomer> pc = StreamMapEx02.filterCustomers(customers);
		pc.forEach(System.out::println);
	}

	public static List<PriorityCustomer> filterCustomers(List<Customer> customers) {
		// List<PriorityCustomer> priorityCustomer = new ArrayList<>();
		// for(Customer temp: customers) {
		// if(temp.getCustomerPurchase()>5000)
		// priorityCustomer.add(new PriorityCustomer(temp.getCustomerId(),
		// temp.getCustomerName(), temp.getCustomerName()));
		// }
		// return customers.stream().map(temp -> {if(temp.getCustomerPurchase()>5000) {
		// return new PriorityCustomer(temp.getCustomerId(), temp.getCustomerName(),
		// "Gold");}else return null;}).collect(Collectors.toList());

//		return customers.stream().filter(temp -> temp.getCustomerPurchase() > 5000).map(temp -> {
//			return new PriorityCustomer(temp.getCustomerId(), temp.getCustomerName(), "Gold");
//		}).collect(Collectors.toList());
		
		return customers.stream().map(temp -> {return new PriorityCustomer(temp.getCustomerId(), temp.getCustomerName(), temp.getCustomerPurchase()>0 && temp.getCustomerPurchase()<3000?"Silver":temp.getCustomerPurchase()>3000&&temp.getCustomerPurchase()<5000?"Gold":"Platinum");}).collect(Collectors.toList());
	}
}
