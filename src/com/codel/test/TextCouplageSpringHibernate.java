package com.codel.test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.codel.daos.ContactDAO;
import com.codel.entities.Address;
import com.codel.entities.Contact;

public class TextCouplageSpringHibernate {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ContactDAO d = (ContactDAO) context.getBean("myContactDao");
		d.update(new Contact("salim", "SMAIL", "salim@gail.com", new Address(0, "h", "h", "003", "g", "g")));
				
	}
}
