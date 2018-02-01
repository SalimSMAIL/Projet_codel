package com.codel.services;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.codel.daos.ContactGroupDAO;
import com.codel.entities.Contact;
import com.codel.entities.ContactGroup;


public class ContactGroupServices {

	public List<ContactGroup> findAll(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ContactGroupDAO groupDao = (ContactGroupDAO)context.getBean("myContactGroupDAO");	
		return groupDao.findAll();

	}
	
	public ContactGroup findById(long id){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ContactGroupDAO groupDao = (ContactGroupDAO)context.getBean("myContactGroupDAO");
		
		return groupDao.findById(id);

	}
	
	public void emptyContactGroup(long id){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ContactGroupDAO groupDao = (ContactGroupDAO)context.getBean("myContactGroupDAO");
		
		ContactGroup gc = groupDao.findById(id);
		gc.removeAllContacts();
		groupDao.update(gc);
		
	}
	
	public void deleteGroup(long id){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ContactGroupDAO groupDao = (ContactGroupDAO)context.getBean("myContactGroupDAO");
		
		groupDao.delete(id);
	}

	public void deleteContact(ContactGroup contactGroup, Contact contact) {	
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ContactGroupDAO groupDao = (ContactGroupDAO)context.getBean("myContactGroupDAO");

		contactGroup.removeContact(contact);
		groupDao.update(contactGroup);
		
	}
	
	public List<Contact> getContacts(long idGroup) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ContactGroupDAO groupDao = (ContactGroupDAO)context.getBean("myContactGroupDAO");

		List <Contact> contacts = groupDao.getContacts(idGroup);
		return contacts;
	}
	
	public String addGroup(String groupName){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ContactGroupDAO groupDao = (ContactGroupDAO)context.getBean("myContactGroupDAO");
		
		if(groupName==null || !groupName.matches("^[a-zA-Z0-9]{2,}$")) return "veuillez saisir un nom de groupe";
		try{
			groupDao.save(new ContactGroup(groupName));
		}catch(Exception e){
			return "Ce nom de groupe existe déja";
		}
		return null;
	}
}
