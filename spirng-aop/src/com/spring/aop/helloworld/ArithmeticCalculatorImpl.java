package com.spring.aop.helloworld;

public class ArithmeticCalculatorImpl implements ArithmeticCalculator {

	@Override
	public int add(int a, int b) {
		int i = a+b;
		return i;
	}

	@Override
	public int sub(int a, int b) {
		int i = a-b;
		return i;
	}

	@Override
	public int mul(int a, int b) {
		int i = a*b;
		return i;
	}

	@Override
	public int div(int a, int b) {
		int i = a/b;
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
