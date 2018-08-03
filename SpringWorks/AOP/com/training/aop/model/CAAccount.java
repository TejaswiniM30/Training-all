package com.training.aop.model;

public class CAAccount {
	private Account acc;

	public Account getAcc() {
		return acc;
	}

	public void setAcc(Account account) {
		this.acc = account;
	}

	public double showBalance() {
		this.getTest();
		return acc.getBalance();
	}
	
	void getTest() {
		System.out.println("This is the default test...");
	}
	
	public void getOneParameter(int x) {
		System.out.println("parameter : "+x);
	}

	@Override
	public String toString() {
		return "CAAccount [account=" + acc + "]";
	}

}
