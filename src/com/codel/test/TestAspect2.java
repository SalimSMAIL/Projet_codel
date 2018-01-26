package com.codel.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.codel.entities.Address;
import com.codel.entities.Contact;
import com.codel.services.ContactServices;

public class TestAspect2  {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ContactServices d = (ContactServices) context.getBean("myContactServices");
		System.out.println(d.testAspect("salime"));//("firstName", "lastName", "email", "streetNumber", "streetType", "streetName", "codePostal", "city", "country"));
		
		
	}

}