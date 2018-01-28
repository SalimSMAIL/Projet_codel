package com.codel.test;

import org.json.JSONException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.codel.daos.ContactDAO;
import com.codel.entities.Contact;
import com.codel.services.ContactServices;

public class TestVersionning1 {

	public static void main(String[] args) throws JSONException {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ContactDAO d = (ContactDAO) context.getBean("myContactDao");
		Contact c = (Contact) d.findById(1l);
		
		
		ContactServices serv = (ContactServices)context.getBean("myContactServices");
		serv.updateContact(c, "firstName", "lastName", "email@gmail.com", "12", "streetType", "streetName", "93000", "city", "country");
		
	}
}
