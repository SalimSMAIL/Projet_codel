package com.codel.services;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.codel.daos.ContactDAO;
import com.codel.daos.ContactGroupDAO;
import com.codel.entities.Address;
import com.codel.entities.Contact;
import com.codel.entities.ContactGroup;

public class ContactServices {
	
	public void addContactToGroup(String idContact,String idGroup) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ContactDAO d = (ContactDAO) context.getBean("myContactDao");
		Contact c1 = findById(Long.parseLong(idContact));
		ContactGroupServices cgs = new ContactGroupServices();
		ContactGroup c2 = cgs.findById(Long.parseLong(idGroup));
		c1.addBooks(c2);
		d.save(c1);
		System.out.println("yes");
	}
	public Contact findById(long id){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ContactDAO contactDAO = (ContactDAO)context.getBean("myContactDao");
		return contactDAO.findById(id);
	}
	
	public List<Contact> findAll(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ContactDAO contactDAO = (ContactDAO)context.getBean("myContactDao");
		return contactDAO.findAll();
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

	public List<Contact> searchContact(String query){
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		ContactDAO contactDAO = (ContactDAO)context.getBean("myContactDao");
//		List<Contact> contacts = new ArrayList<Contact>();
//		List<Contact> contacts_results = new ArrayList<Contact>();
//		contacts = contactDAO.findAll();
//		for (int i = 0; i < contacts.size(); i++) {
//			if (contacts.get(i).getFirstName().contains(query)
//					|| contacts.get(i).getLastName().contains(query)
//					) {
//				contacts_results.add(contacts.get(i));
//			}		
//		}
//		if(contacts.isEmpty()) {
//			return null;
//		}else {
//			return contacts_results;
//		}
			
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ContactDAO contactDAO = (ContactDAO)context.getBean("myContactDao");
		return contactDAO.searchContact(query);
	}

	
}
