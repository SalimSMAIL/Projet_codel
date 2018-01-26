package com.codel.test;

import org.aspectj.lang.ProceedingJoinPoint;

public class TestAspect {

	public void test(ProceedingJoinPoint pjp, Object c){
		System.out.println("je suis dans l'aspect");
		try {
			pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
	}
}
