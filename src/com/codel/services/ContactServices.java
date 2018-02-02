package com.codel.services;

import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.codel.daos.interfaces.IContactDAO;
import com.codel.entities.Address;
import com.codel.entities.Contact;
import com.codel.entities.ContactGroup;
import com.codel.entities.PhoneNumber;

public class ContactServices {

	private IContactDAO contactDAO;

	public ContactServices(){
		super();
	}

	public ContactServices(IContactDAO contactDAO){
		this.contactDAO = contactDAO;
	}

	public void addContactToGroup(Contact contact, ContactGroup contactGroup) {
		contact.addBooks(contactGroup);
		contactDAO.update(contact);
	}

	public Contact findById(long id){
		return contactDAO.findById(id);
	}

	public List<Contact> findAll(){
		return contactDAO.findAll();
	}

	public void deleteContactbyId(long id){
		contactDAO.delete(id);
	}

	public JSONObject addContact(String firstName, String lastName, String email, 
			String streetNumber, String streetType, String streetName, String codePostal, 
			String city, String country, Map<String, String> listPhones) throws JSONException{

		long sn;
		try{
			sn = Long.parseLong(streetNumber);
		}catch(Exception e){
			sn=1000;
		}
		Contact contact = new Contact(firstName, lastName, email, new Address(sn, 
				streetType, streetName, codePostal, city, country));
		if(listPhones.containsKey("mobilePhone") && listPhones.get("mobilePhone").matches("^0[1-9][0-9]{8,}$")) new PhoneNumber(listPhones.get("mobilePhone"), "mobile", contact);
		if(listPhones.containsKey("homePhone") && listPhones.get("homePhone").matches("^0[1-9][0-9]{8,}$")) new PhoneNumber(listPhones.get("homePhone"), "home", contact);
		if(listPhones.containsKey("professionnalPhone") && listPhones.get("professionnalPhone").matches("^0[1-9][0-9]{8,}$")) new PhoneNumber(listPhones.get("professionnalPhone"), "professionnal", contact);
		long id = contactDAO.save(contact);

		return new JSONObject().put("id", id);

	}

	public JSONObject updateContact(Contact contact, String firstName, String lastName, String email, 
			String streetNumber, String streetType, String streetName, 
			String codePostal, String city, String country, Map<String, String> listPhones) throws JSONException{


		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		contact.setEmail(email);
		contact.getAddress().setStreetNumber(Long.parseLong(streetNumber));
		contact.getAddress().setStreetName(streetName);
		contact.getAddress().setCodePostal(codePostal);
		contact.getAddress().setCity(city);
		contact.getAddress().setCountry(country);

		if(listPhones.containsKey("mobilePhone") && listPhones.get("mobilePhone").matches("^0[1-9][0-9]{8,}$")){
			if(contact.getPhone("mobile")==null) new PhoneNumber(listPhones.get("mobilePhone"), "mobile", contact);	
			else contact.getPhone("mobile").setPhoneNumber(listPhones.get("mobilePhone"));
		}
		if(listPhones.containsKey("homePhone") && listPhones.get("homePhone").matches("^0[1-9][0-9]{8,}$")){
			if(contact.getPhone("home")==null) new PhoneNumber(listPhones.get("homePhone"), "home", contact);	
			else contact.getPhone("home").setPhoneNumber(listPhones.get("homePhone"));
		}
		if(listPhones.containsKey("professionnalPhone") && listPhones.get("professionnalPhone").matches("^0[1-9][0-9]{8,}$")){
			if(contact.getPhone("professionnal")==null) new PhoneNumber(listPhones.get("professionnalPhone"), "professionnal", contact);	
			else contact.getPhone("professionnal").setPhoneNumber(listPhones.get("professionnalPhone"));
		}

		contactDAO.update(contact);

		return new JSONObject().put("id", contact.getContactId());

	}

	public List<Contact> searchContact(String query){
		return contactDAO.searchContact(query);
	}


}
