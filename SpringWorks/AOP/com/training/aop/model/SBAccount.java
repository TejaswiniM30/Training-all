package com.training.aop.model;

public class SBAccount {
	private Account acc;

	@Override
	public String toString() {
		return "SBAccount [acc=" + acc + "]";
	}

	public Account getAcc() {
		return acc;
	}

	public void setAcc(Account acc) {
		this.acc = acc;
	}
	
	public double showBalance() {
		return acc.getBalance();
	}
	
}
