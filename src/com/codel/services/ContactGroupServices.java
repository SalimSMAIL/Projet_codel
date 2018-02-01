package com.codel.services;

import java.util.List;

import com.codel.daos.interfaces.IContactGroupDAO;
import com.codel.entities.Contact;
import com.codel.entities.ContactGroup;


public class ContactGroupServices {
	
	 private IContactGroupDAO contactGroupDAO;
	 
	 public ContactGroupServices(){
		 super();
	 }

	public ContactGroupServices(IContactGroupDAO contactGroupDAO){
		this.contactGroupDAO = contactGroupDAO;
	}

	public List<ContactGroup> findAll(){	
		return contactGroupDAO.findAll();

	}
	
	public ContactGroup findById(long id){
		return contactGroupDAO.findById(id);

	}
	
	public void emptyContactGroup(long id){
		ContactGroup gc = contactGroupDAO.findById(id);
		gc.removeAllContacts();
		contactGroupDAO.update(gc);
	}
	
	public void deleteGroup(long id){
		contactGroupDAO.delete(id);
	}

	public void deleteContact(ContactGroup contactGroup, Contact contact) {
		contactGroup.removeContact(contact);
		contactGroupDAO.update(contactGroup);
	}
	
	public List<Contact> getContacts(long idGroup) {
		List <Contact> contacts = contactGroupDAO.getContacts(idGroup);
		return contacts;
	}
	
	public String addGroup(String groupName){
		if(groupName==null || !groupName.matches("^[a-zA-Z0-9]{2,}$")) return "veuillez saisir un nom de groupe";
		try{
			contactGroupDAO.save(new ContactGroup(groupName));
		}catch(Exception e){
			return "Ce nom de groupe existe déja";
		}
		return null;
	}
}
