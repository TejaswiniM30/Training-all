package com.exilant.day2;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;
import java.util.*;

public class RandomFilterEx {

	public static void main(String[] args) {
		int randomNumber = ThreadLocalRandom.current().nextInt(100, 200);
		System.out.println(randomNumber);
		
		Random random = new Random();
		random.ints(10, 100, 200).forEach(System.out::println);
		System.out.println("--------------------------------------------");
		
		//we want in sorted order
		random.ints(10, 1000, 1200).sorted().forEach(System.out::println);
		System.out.println("---------------------------------------------");
		
		System.out.println(random.ints(10, 200, 300).sum());
		
		Stream.iterate(10, i->i+1).limit(20).sorted().forEach(System.out :: println);
		
	}

}
