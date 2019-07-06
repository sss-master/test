package com.spring.aop.annotation;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/*将本类声明为切面:
 *     1、将该类放入IOC容器
 * 	   2、声明为切面
 */
@Order(value = 2)//切面优先级设置
@Component
@Aspect
public class LoggingAspect{
	
	//声明切入点表达式实现代码重用,在声明通知时引用方法名即可
	@Pointcut(value = "execution(* com.spring.aop.annotation.*.*(..))")
	public void declareJoinPointExpression() {
		
	}
	
	//声明前置通知:在目标方法执行之前通知
	@Before("declareJoinPointExpression()")
	public void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("The method "+methodName+" begins with "+Arrays.asList(args));
	}
	
	//声明后置通知:在目标方法执行之后通知,无论是否发生异常
	//在后置通知中还不能得到方法执行后的返回值
	@After("declareJoinPointExpression()")
	public void afterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" ends with "+joinPoint.getTarget());
	}
	
	//返回通知:在目标方法【正常】执行之后通知,能获得方法返回值
	@AfterReturning(value = "declareJoinPointExpression()",returning = "results")
	public void afterReturningMethod(JoinPoint joinPoint,Object results) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" ends with "+results);
	}
	
	//异常通知:目标方法抛出异常后执行,可以指定抛出某个类型的异常时通知
	@AfterThrowing(value = "declareJoinPointExpression()",throwing = "ex")
	public void afterThrowingMethod(JoinPoint joinPoint,Exception ex) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" occurs exception "+ex.getMessage());
	}
	
	//环绕通知:需要携带ProceedingJoinPoint参数
//	@Around(value = "execution(* com.spring.aop.annotation.*.*(..))")
//	public Object aroundMethod(ProceedingJoinPoint pjd) {
//		
//		//返回值
//		Object result = null;
//		
//		//方法名
//		String methodName = pjd.getSignature().getName();
//		
//		//方法参数
//		Object[] args = pjd.getArgs();
//		
//		//执行目标方法
//		try {
//			//前置通知
//			System.out.println("The method "+methodName+" begins with "+Arrays.toString(args));
//			result = pjd.proceed();
//			//返回通知
//			System.out.println("The method "+methodName+" ends with "+result);
//		} catch (Throwable e) {
//			//异常通知
//			System.out.println("The method "+methodName+" occurs exception "+e.getMessage());
//		}
//		//后置通知
//		System.out.println("The method "+methodName+" ends");
//		return result;
//	}
	
}
