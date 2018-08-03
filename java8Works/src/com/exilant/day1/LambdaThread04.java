package com.exilant.day1;

public class LambdaThread04 {

	public static void main(String[] args) {
		//runnable should be passed to the thread constructor
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Hi im from anonymous call---start");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Anonymous call exiting");
			}
		}).start();
		
		//We create a runnable using lambda expression (since runnable is a functional interface)
		
		new Thread(()->{System.out.println("Hi im from lambda---start");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Lambda call exiting");}).start();
	}

}
