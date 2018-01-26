package com.codel.services;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.codel.daos.ContactDAO;
import com.codel.entities.Address;
import com.codel.entities.Contact;

public class ContactServices {
	
	
	public JSONObject addContact(String firstName, String lastName, String email, 
				String streetNumber, String streetType, String streetName, String codePostal, String city, String country) throws JSONException{
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ContactDAO contactDAO = (ContactDAO)context.getBean("myContactDao");
		
		Contact contact = new Contact(firstName, lastName, email, new Address(Long.parseLong(streetNumber), 
									streetType, streetName, codePostal, city, country));
		contactDAO.save(contact);
		
		return new JSONObject();
		
	}

	
}
