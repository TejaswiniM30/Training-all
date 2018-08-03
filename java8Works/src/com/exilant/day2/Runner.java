package com.exilant.day2;


//all bussiness logic goes here
public class Runner {
public void execute(WorkerInterface workerInterface) {
	System.out.println("In Execute method....");
	workerInterface.doSomeWork();
}
}
