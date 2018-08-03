package com.training.aop.model;

import javax.management.RuntimeErrorException;

public class BankingService {
	private SBAccount sbAccount;
	private CAAccount caAccount;
	public SBAccount getSbAccount() {
		return sbAccount;
	}
	public void setSbAccount(SBAccount sbAccount) {
		this.sbAccount = sbAccount;
	}
	public CAAccount getCaAccount() {
		return caAccount;
	}
	public void setCaAccount(CAAccount caAccount) {
		this.caAccount = caAccount;
	}
	@Override
	public String toString() {
		return "BankingService [sbAccount=" + sbAccount + ", caAccount=" + caAccount + "]";
	}
	public BankingService(SBAccount sbAccount, CAAccount caAccount) {
		super();
		this.sbAccount = sbAccount;
		this.caAccount = caAccount;
	}
	public BankingService() {
		super();
	}
	
	public String setAndGet(String name) {
		return "Hello Mr/Ms/Mrs "+name;
	}
	
	public void throwSomeException() {
		int a=1;
		if(a==1) {
			throw new RuntimeException("User threw exception");
		}
		System.out.println("throw some exception was invoked");
		
	}
	
}
