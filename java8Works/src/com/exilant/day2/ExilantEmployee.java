package com.exilant.day2;

public class ExilantEmployee implements IEmployee, IDepartment{
 @Override
public void salary() {
	// TODO Auto-generated method stub
	 System.out.println("salary");
	
}

@Override
public void noOfHrs() {
	// TODO Auto-generated method stub
	IDepartment.super.noOfHrs();
}
 
		
	
	

}
