//package com.training.aop.banking;
//
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Aspect;
//
//@Aspect
//public class LoggingAspectAfter {
//	@After("execution(* get*())")
//	public void afterGetter() {
//		System.out.println("$$$$$ after advice ");
//	}
//	
//	@AfterReturning("execution(* com.training.aop.model.SBAccount.getAcc())")
//	public void afterSuccessfulGetter() {
//		System.out.println("$$$$ after successful return of sb account $$$$");
//	}
//	
//	@AfterReturning(pointcut = "args(val)", returning="returnString")
//	public void afterReturnStringSetter(String val, String returnString) {
//		System.out.println("After invoked for input -> "+val+" return - > "+returnString);
//	}
//	
//	@AfterThrowing("execution(* throw*())")
//	public void  afterException() {
//		System.out.println("This is invoked for all exceptions only");
//	}
//}
