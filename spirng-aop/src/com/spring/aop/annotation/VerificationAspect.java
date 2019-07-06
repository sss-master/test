package com.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Order(value = 1)//切面优先级设置
@Aspect
@Component
public class VerificationAspect {
	
	@Before("com.spring.aop.annotation.LoggingAspect.declareJoinPointExpression()")
	public void VerificationMethod(JoinPoint joinPoint) {
		System.out.println("The verification method--->"+joinPoint.getSignature().getName());
	}
}
