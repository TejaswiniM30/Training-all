package com.exilant.day1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class LambdaThreadService {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// java 7 and older way
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		executorService.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println("Hi i'm anonymous block");
			}
		});
		
		executorService.shutdown();
		ExecutorService executorService1 = Executors.newSingleThreadExecutor();
		executorService1.execute(()->System.out.println("Hi im in lambda block"));
		executorService1.shutdown();
		
		ExecutorService executorService2 = Executors.newSingleThreadExecutor();
		Set<Callable<String>> callables = intializeCallables();
//		String result = executorService2.invokeAny(callables);
//		System.out.println(result);
		List<Future<String>> results = executorService2.invokeAll(callables);
		for(Future temp : results) {
			System.out.println(temp.get());
			System.out.println(temp.isDone());
		}
		executorService2.shutdown();
		
		
		
		
		
	}
	//this method will create set of callables (each callable is 1 thread)
	public static Set<Callable<String>> intializeCallables(){
		Set<Callable<String>> callables = new HashSet<Callable<String>>();
		callables.add(()->"1st callable");
		callables.add(()->"2st callable");
		callables.add(()->"3st callable");
		callables.add(()->"4st callable");
		callables.add(new Callable<String>() {
			public String call() throws Exception {
				return "Callable thread in anonymous class";
			}
		});
		callables.add(()->{return "complex business logic";});
		return callables;
		
	}
}
