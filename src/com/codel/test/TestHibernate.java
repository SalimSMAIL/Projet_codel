package com.codel.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.codel.utils.HibernateUtility;

public class TestHibernate {

	public static void main(String[] args){
	
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(new com.codel.entities.Address(33, "Boulevard", "Gallieni", "93360", "Neuilly Plaisance", "France"));
		session.getTransaction().commit();
		session.close();
	}
}
