package com.codel.test;

import org.json.JSONException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.codel.entities.Address;
import com.codel.entities.Contact;
import com.codel.services.ContactServices;

public class TestAspect  {

	public static void main(String[] args) throws JSONException {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ContactServices d = (ContactServices) context.getBean("myContactServices");
		System.out.println(d.updateContact(d.find(1),"firstName", "lastName", "email@gmail.com", "12", "streetType", "streetName", "93000", "city", "country"));
		
		
	}

}