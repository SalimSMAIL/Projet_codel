package com.codel.services;

import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.codel.daos.ContactDAO;
import com.codel.entities.Address;
import com.codel.entities.Contact;

public class ContactServices {
	
	private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	private ContactDAO contactDAO = (ContactDAO)context.getBean("myContactDao");
	
	public JSONObject addContact(String firstName, String lastName, String email, 
				String streetNumber, String streetType, String streetName, String codePostal, String city, String country){
		
//		if(firstName==null || firstName.equals("")) return Response.FIRSTNAME_NOT_FOUND;
//		if(lastName==null || lastName.equals("")) return Response.LASTTNAME_NOT_FOUND;
//		if(email==null || email.equals("")) return Response.EMAIL_NOT_FOND;
//		if(streetNumber==null || streetNumber.equals("")) return Response.STREETNUMBER_NOT_FOUND;
//		if(streetType==null || streetType.equals("")) return Response.STREETTYPE_NOT_FOUND;
//		if(streetName==null || streetName.equals("")) return Response.STREETNAME_NOT_FOUND;
//		if(codePostal==null || codePostal.equals("")) return Response.CODEPOSTAL_NOT_FOUND;
//		if(city==null || city.equals("")) return Response.CITY_NOT_FOUND;
//		if(country==null || country.equals("")) return Response.COUNTRY_NOT_FOUND;
		
//		Contact contact = new Contact(firstName, lastName, email, new Address(Long.parseLong(streetNumber), 
//									streetType, streetName, codePostal, city, country));
//		contactDAO.save(contact);
		return new JSONObject();
		
	}
	
	public String testAspect(String name){
		System.out.println("je suis dans la méthode");
		return "methode";
	}
	
}
