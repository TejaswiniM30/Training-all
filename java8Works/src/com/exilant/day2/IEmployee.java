package com.exilant.day2;

public interface IEmployee {
	public void salary();
	
	//default methods can have business logic
	public default void noOfHrs() {
		System.out.println("From IEmployee: Every employee has to work for 10 hours");
	}
	
}
