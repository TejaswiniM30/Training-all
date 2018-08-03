package com.exilant.day2;

public class WorkerInterfaceTest {

	public static void main(String[] args) {
		Runner runner = new Runner();
		
		//using anonymous class (before java 1.8)
		runner.execute(new WorkerInterface() {
			
			@Override
			public void doSomeWork() {
				System.out.println("Hi we are doing some work in main");
			}
		});
		
		
		//in java 8 using lambda expression
		runner.execute(()->System.out.println("Hi im in lambda way in main"));
		
		runner.execute(()->{System.out.println("In lambda way multiple lines");
		System.out.println("you can have any business logic here");});
	}

}
