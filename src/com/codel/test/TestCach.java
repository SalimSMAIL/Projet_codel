package com.codel.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.codel.daos.ContactDAO;
import com.codel.services.ContactGroupServices;

public class TestCach {

	public static void main(String[] args){
		
//		
//		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		session.get(Contact.class, 1l);
//		session.getTransaction().commit();
//		session.close();
//		
//		sessionFactory = HibernateUtility.getSessionFactory();
//		Session session2 = sessionFactory.openSession();
//		session2.beginTransaction();
//		session2.get(Contact.class, 1l);
//		session2.getTransaction().commit();
//		session2.close();
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ContactDAO contactDAO = (ContactDAO)context.getBean("myContactDAO");
		
		contactDAO.findById(1l);
		

		contactDAO.findById(1l);
		
	}
}
