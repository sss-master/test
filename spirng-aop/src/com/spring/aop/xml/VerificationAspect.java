package com.spring.aop.xml;

import org.aspectj.lang.JoinPoint;


public class VerificationAspect {
	
	public void verificationMethod(JoinPoint joinPoint) {
		System.out.println("The verification method--->"+joinPoint.getSignature().getName());
	}
}
