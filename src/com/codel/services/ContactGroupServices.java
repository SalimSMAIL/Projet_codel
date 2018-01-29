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
}
