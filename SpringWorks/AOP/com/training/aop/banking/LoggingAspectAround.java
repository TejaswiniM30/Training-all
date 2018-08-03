package com.training.aop.banking;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspectAround {
	
	
	@Around("execution(public * get*())")
	public Object sampleMyAroundAdvise(ProceedingJoinPoint proceedingJoinPoint) {
		//the advise should have compulsory argument
		Object retVal = null;
		
		try {
			System.out.println("Before job goes  here..");
			retVal =proceedingJoinPoint.proceed();
			System.out.println("After job goes here");
		}catch(Throwable e) {
			e.printStackTrace();
		}
		return retVal;
	}
}
