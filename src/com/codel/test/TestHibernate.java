package com.codel.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.codel.entities.Address;
import com.codel.entities.Contact;
import com.codel.entities.PhoneNumber;
import com.codel.utils.HibernateUtility;

public class TestHibernate {

	public static void main(String[] args){
		
		Address add = new Address(33, "Boulevard", "Gallieni", "93360", "Neuilly Plaisance", "France");
		Contact c = new Contact("salim", "smail", "sm@gmail.com", "blabla", add);
		PhoneNumber p = new PhoneNumber("07858848", "blabla", c);
		
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		session.persist(c);
		
		Contact c1 = session.load(Contact.class, c.getContactId());
		System.out.println(c1.getPhones().iterator().next().getPhoneNumber());
		session.delete(c1);
		
		session.getTransaction().commit();
		session.close();
	}
}
