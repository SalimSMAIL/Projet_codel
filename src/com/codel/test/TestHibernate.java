package com.codel.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.codel.entities.Contact;
import com.codel.utils.HibernateUtility;

public class TestHibernate {

	public static void main(String[] args){
		
		Contact c1;
		
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		c1 = (Contact) session.load(Contact.class, 1l);
//		session.delete(c1);
		System.out.println(c1.getFirstName());
		session.getTransaction().commit();
		session.close();
	}
}
