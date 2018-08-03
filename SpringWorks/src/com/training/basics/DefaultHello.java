package com.training.basics;

public class DefaultHello implements HelloService{
	private String name;
	private String city;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String sayHello() {
		// TODO Auto-generated method stub
		return sayHello(name, city);
	}

	public DefaultHello(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}

	public DefaultHello() {
		super();
	}

	@Override
	public String sayHello(String name, String city) {
		// TODO Auto-generated method stub
		
		String myStrs[] = {
				"hey how are you Ms %s and how is your %s",
				"Good morning %s are you in %s",
				"Ms %s your city is beautiful %s"
		};
		int randomNumber = (int)Math.random()*3;
		return String.format(myStrs[randomNumber], name,city);
	}
	
	public void ginit() {
		System.out.println("Global init of Defaulthello");
	}
	public void gdestroy() {
		System.out.println("Global destroy of defaulthello");
	}
	

}
