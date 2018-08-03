package com.exilant.day2;

import java.util.Arrays;
import java.util.List;

public class PersonClient {
	public static void main(String[] args) {
		List<Person> personList = Arrays.asList(new Person(101, "John"), new Person(102, "David"),
				new Person(103, "Arjun"), new Person(104, "Ben"));

		personList.forEach(System.out::println);

		PersonConsumer print = new PersonConsumer();
		// we are passing our own consumer
		personList.forEach(print);
		personList.forEach(PrintConsumer :: print);

	}
}
