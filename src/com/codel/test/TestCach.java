package com.codel.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.codel.entities.Contact;
import com.codel.utils.HibernateUtility;

public class TestCach {

	public static void main(String[] args){
		
		
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.get(Contact.class, 1l);
		session.getTransaction().commit();
		session.close();
		
		sessionFactory = HibernateUtility.getSessionFactory();
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		session2.get(Contact.class, 1l);
		session2.getTransaction().commit();
		session2.close();
	}
}
