package com.exilant.day2;

public interface IDepartment {
public default void noOfHrs() {
	System.out.println("From Idepartment : every emp works for 8 hrs");
}

public static void commonUtility() {
	System.out.println("Employees must pass Background verification");
}

}
