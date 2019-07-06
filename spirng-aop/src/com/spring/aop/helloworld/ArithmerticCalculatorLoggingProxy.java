package com.spring.aop.helloworld;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ArithmerticCalculatorLoggingProxy {
	
	//要代理的对象
	private ArithmeticCalculator target;
	
	public ArithmerticCalculatorLoggingProxy(ArithmeticCalculator target) {
		this.target = target;
	}
	
	//得到代理目标对象
	public ArithmeticCalculator getLoggingProxy() {
		ArithmeticCalculator proxy = null;
		
		//代理对象的类加载器
		ClassLoader loader = target.getClass().getClassLoader();
		
		//代理对象的类型,即其中有哪些方法
		Class[] interfaces =  new Class[] {ArithmeticCalculator.class};
		
		//调用方法时执行该代码
		InvocationHandler h = new InvocationHandler() {
			//proxy:正在返回的代理对象
			//method:被调用的方法
			//args:方法参数
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				String methodName = method.getName();
				//日志
				System.out.println("当前执行的方法为:"+methodName+",参数为:"+Arrays.toString(args));
				//执行方法
				Object i = null;
				
				try {
					//前置通知
					i = method.invoke(target, args);
					//返回通知,可以访问方法的返回值
				} catch (Exception e) {
					e.printStackTrace();
					//异常通知
				}
				//后置通知,因为方法可能抛出异常,则访问不到返回值
				
				//日志
				System.out.println(methodName+"方法执行的结果为:"+i);
				return i;
			}
		};
		proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, h);
		
		return proxy;
	}
	
	public static void main(String[] args) {
		ArithmeticCalculator target = new ArithmeticCalculatorImpl();
		ArithmeticCalculator proxy = new ArithmerticCalculatorLoggingProxy(target).getLoggingProxy();
		proxy.add(1, 3);
	}
	
}
