package com.spring.aop.annotation;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext c = new GenericXmlApplicationContext("annotation-aop.xml");
		
		ArithmeticCalculator ac = (ArithmeticCalculator) c.getBean("c");
		
		ac.add(15, 3);
		System.out.println();
		ac.sub(15, 3);
		System.out.println();
		ac.mul(15, 3);
		System.out.println();
		ac.div(15, 5);
	}

}
