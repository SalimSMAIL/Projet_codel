package com.codel.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.codel.entities.Address;
import com.codel.utils.HibernateUtility;

public class TestHibernate {

	public static void main(String[] args){
	
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Address add = new Address(33, "Boulevard", "Gallieni", "93360", "Neuilly Plaisance", "France");
		session.save(add);
		
		session.getTransaction().commit();
		session.close();
	}
}
