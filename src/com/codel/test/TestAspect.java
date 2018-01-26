package com.codel.test;

import org.aspectj.lang.ProceedingJoinPoint;

public class TestAspect {

	public String test(ProceedingJoinPoint pjp, String name){
		System.out.println("je suis dans l'aspect");
		return "aspect";
	}
}
