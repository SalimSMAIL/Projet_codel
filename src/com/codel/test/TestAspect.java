package com.codel.test;

import org.aspectj.lang.ProceedingJoinPoint;

public class TestAspect {

	public Object test(ProceedingJoinPoint pjp, Object c){
		System.out.println("je suis dans l'aspect");
		try {
		Object result =  pjp.proceed();
		System.out.println(result);
		return result;
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
	}
}
