package com.exilant.day1;
//this program to show simple working of functional interfaces

//if you have an interface and that interface has exactly 1 method then that interface can be eligible to be functional interface
@FunctionalInterface
interface MathOperation{
	int operation(int num1, int num2);
}
public class LambdaEx03 {
	//we are passing functions as parameters
	public static int operate(int num1, int num2, MathOperation opr) {
		return opr.operation(num1, num2);
	}
	public static void main(String[] args) {
		MathOperation add = (int num1, int num2) -> num1 + num2;
		MathOperation sub = (int num1, int num2) -> num1 - num2;
		
		System.out.println(operate(10,20, add));
		System.out.println(operate(20,30, sub)); 
	}

}
