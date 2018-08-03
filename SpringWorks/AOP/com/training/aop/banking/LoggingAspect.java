//package com.training.aop.banking;
//
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//
//@Aspect
//public class LoggingAspect {
//	
//	
//	//this will scan for any package(configured)
//	//this will scan for any class
//	
//	//to specify the method exactly but this will find in any account
//	//@Before("execution(public double getBalance())")
//	
//	//we can also have fully qualified name
//	//@Before("execution(public double com.training.aop.model.CAAccount.showBalance())")
//	//@Before("execution(public * get*())")
//	//regex for taking 1 parameter
//	//@Before("execution( * get*(*))")
//	//with or without parameters
//	//@Before("execution( * get*(..))")
//	//any return type in any class of package com.training.aop.model
//	//@Before("execution(* com.training.aop.model.*.getBalance()")
//	public void loggingAdviceBefore() {
//		System.out.println("******Logging before called**********");
//	}
//	//if you have too many advices then its difficult to maintain so we create a dummy method annotated with the regex and we can use this method instead of 
//	//annotation
//	
//	@Pointcut("execution(* get*(..))")
//	public void allGetters() {
//		System.out.println();
//	}
//	
//	@Pointcut("execution(* com.training.aop.model.SBAccount.showBalance())")
//	public void getAllSbAccount() {
//		System.out.println();
//	}
//	
////	@Before("getAllSbAccount()")
////	public void ThirdAdvice() {
////		System.out.println("Third aspect invoked for all sb account");
////	}
//	
////	@Before("allGetters()")
////	public void secondAdvise() {
////		System.out.println("Second aspect invoked for all getters...");
////	}
//	
//	@Before("allGetters() || getAllSbAccount()")
//	public void CompoundAdvice() {
//		System.out.println("Fourth aspect invoked ");
//	}
//	
//	
//	
//	
////	@After("execution(public double getBalance())")
////	public void loggingAdviceAfter() {
////		System.out.println("******Logging after called**********");
////	}
//	
//	
//}
