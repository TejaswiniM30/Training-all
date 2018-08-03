package com.exilant.day1;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
//program to show working of loops in jdk 1.7 and jdk 1.8
public class LambdaBasics01 {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50, 60);
		
		System.out.println(numbers.stream().mapToInt(x->(int)x).sum());
		
		System.out.println(numbers.stream().mapToInt(x->(int)x).reduce(0, (result,n)->result+n));
	//	System.out.println(numbers.stream().mapTo(n->(int)(n*2)).reduce(1, (res,n)->(res * n)));
		
		System.out.println("-----till jdk 1.5------");
		//till jdk 1.5
		for (int i = 0; i < numbers.size(); i++) {
			System.out.println(numbers.get(i));
		}
		System.out.println("-----from jdk 1.7------");
		//till jdk 1.7
		for(Integer temp: numbers) {
			System.out.println(temp);
		}
		System.out.println("----from jdk 1.8--------");
		//from jdk 1.8 with lambda
		numbers.forEach((Integer temp) -> System.out.println(temp));
		numbers.forEach(temp -> System.out.println(temp));
		
		//behind the screen
		System.out.println("-----with consumer-----");
		numbers.forEach(new Consumer<Integer>() {
			public void accept(Integer t) {
				System.out.println(t);
			}; 
		});
		
		System.out.println("Method reference");
		numbers.forEach(System.out :: println);
		
		
	}
}
