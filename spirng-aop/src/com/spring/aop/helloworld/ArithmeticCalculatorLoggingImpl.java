package com.spring.aop.helloworld;

public class ArithmeticCalculatorLoggingImpl implements ArithmeticCalculator {

	@Override
	public int add(int a, int b) {
		System.out.println("The method add begins with["+a+","+b+"]");
		int i = a+b;
		System.out.println("The method add end with"+i);
		return i;
	}

	@Override
	public int sub(int a, int b) {
		System.out.println("The method sub begins with["+a+","+b+"]");
		int i = a-b;
		System.out.println("The method sub end with"+i);
		return i;
	}

	@Override
	public int mul(int a, int b) {
		System.out.println("The method mul begins with["+a+","+b+"]");
		int i = a*b;
		System.out.println("The method mul end with"+i);
		return i;
	}

	@Override
	public int div(int a, int b) {
		System.out.println("The method div begins with["+a+","+b+"]");
		int i = a/b;
		System.out.println("The method div end with"+i);
		return i;
	}
//	public static void main(String[] args) {
//		int a = 4,b=2;
//		System.out.println(new ArithmeticCalculatorImpl().add(a, b));
//		System.out.println(new ArithmeticCalculatorImpl().sub(a, b));
//		System.out.println(new ArithmeticCalculatorImpl().mul(a, b));
//		System.out.println(new ArithmeticCalculatorImpl().div(a, b));
//	}

}
