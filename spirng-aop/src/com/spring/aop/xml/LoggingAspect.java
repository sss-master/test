package com.spring.aop.xml;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;


public class LoggingAspect{
	
	public void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("The method "+methodName+" begins with "+Arrays.asList(args));
	}
	
	public void afterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" ends with "+joinPoint.getTarget());
	}
	
	public void afterReturningMethod(JoinPoint joinPoint,Object result) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" ends with "+result);
	}
	
	public void afterThrowingMethod(JoinPoint joinPoint,Exception ex) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" occurs exception "+ex.getMessage());
	}
	
	@Around("execution(* com.spring.aop.xml.*.*(..)")
	public Object aroundMethod(ProceedingJoinPoint pjd) {
		
		//返回值
		Object result = null;
		
		//方法名
		String methodName = pjd.getSignature().getName();
		
		//方法参数
		Object[] args = pjd.getArgs();
		
		//执行目标方法
		try {
			//前置通知
			System.out.println("The method "+methodName+" begins with "+Arrays.toString(args));
			result = pjd.proceed();
			//返回通知
			System.out.println("The method "+methodName+" ends with "+result);
		} catch (Throwable e) {
			//异常通知
			System.out.println("The method "+methodName+" occurs exception "+e.getMessage());
		}
		//后置通知
		System.out.println("The method "+methodName+" ends");
		return result;
	}
	
}
