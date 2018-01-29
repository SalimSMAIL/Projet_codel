package com.codel.services;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.codel.daos.ContactDAO;
import com.codel.entities.Address;
import com.codel.entities.Contact;

public class ContactServices {
	
	public Contact findById(long id){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ContactDAO contactDAO = (ContactDAO)context.getBean("myContactDao");
		return contactDAO.findById(id);
	}
	
	public void deleteContactbyId(long id){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ContactDAO contactDAO = (ContactDAO)context.getBean("myContactDao");
		contactDAO.delete(id);
	}
	
	public JSONObject addContact(String firstName, String lastName, String email, 
				String streetNumber, String streetType, String streetName, String codePostal, String city, String country) throws JSONException{
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ContactDAO contactDAO = (ContactDAO)context.getBean("myContactDao");
		long sn;
		try{
			sn = Long.parseLong(streetNumber);
		}catch(Exception e){
			sn=1000;
		}
		Contact contact = new Contact(firstName, lastName, email, new Address(sn, 
									streetType, streetName, codePostal, city, country));
		long id = contactDAO.save(contact);
		
		return new JSONObject().put("id", id);
		
	}
	
public JSONObject updateContact(Contact contact, String firstName, String lastName, String email, 
			String streetNumber, String streetType, String streetName, String codePostal, String city, String country) throws JSONException{
	
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	ContactDAO contactDAO = (ContactDAO)context.getBean("myContactDao");
	
	contact.setFirstName(firstName);
	contact.setLastName(lastName);
	contact.setEmail(email);
	contact.getAddress().setStreetNumber(Long.parseLong(streetNumber));
	contact.getAddress().setStreetName(streetName);
	contact.getAddress().setCodePostal(codePostal);
	contact.getAddress().setCity(city);
	contact.getAddress().setCountry(country);
	
	contactDAO.update(contact);
	
	return new JSONObject().put("id", contact.getContactId());
	
}

	
}
