package com.codel.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.codel.entities.Contact;
import com.codel.utils.HibernateUtility;

public class TestHibernate {

	public static void main(String[] args){
		
		Contact c1;
		
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		c1 = session.load(Contact.class, 1l);
		c1.setFirstName("blabla");
		
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("je commiteeeeeeeeeeeeee");
		session.getTransaction().commit();
		session.close();
	}
}
