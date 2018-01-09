package com.codel.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.codel.entities.Address;
import com.codel.entities.Contact;
import com.codel.entities.ContactGroup;
import com.codel.entities.PhoneNumber;
import com.codel.utils.HibernateUtility;
import com.sun.beans.util.Cache;

public class TestHibernate {

	public static void main(String[] args){
		
		Address add = new Address(33, "Boulevard", "Gallieni", "93360", "Neuilly Plaisance", "France");
		Contact c = new Contact("salim", "smail", "sm@gmail.com", "blabla", add);
		PhoneNumber pn = new PhoneNumber("0782482955", "mobile", c);
//		Set<PhoneNumber> phones = new HashSet();
//		phones.add(pn);
//		c.setPhones(phones);
		
		ContactGroup cg = new ContactGroup("salim Groupe");
	
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		session.persist(pn);
		
		Contact c1 = session.load(Contact.class, c.getContactId());
		System.out.println(c1.getPhones().iterator().next().getPhoneNumber());
		
		session.getTransaction().commit();
		session.close();
	}
}
