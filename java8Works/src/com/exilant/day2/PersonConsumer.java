package com.exilant.day2;

import java.util.function.Consumer;

public class PersonConsumer implements Consumer<Person>{
	@Override
	public void accept(Person t) {
		System.out.println("Person details: "+t.pid+" "+t.name);
	}

}

class PrintConsumer {
	public static void print(Person p) {
		System.out.println("Static reference: "+p.name+" "+p.pid);
	}
}
