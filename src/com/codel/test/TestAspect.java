package com.codel.test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.codel.daos.ContactDAO;
import com.codel.services.ContactServices;

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
