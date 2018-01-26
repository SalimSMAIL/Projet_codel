package com.codel.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.codel.daos.ContactDAO;
import com.codel.entities.Contact;

public class TestVersionning2 {

	public static void main(String[] args) throws InterruptedException {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ContactDAO d = (ContactDAO) context.getBean("myContactDao");
		Contact c = (Contact) d.findById(1l);
		c.setFirstName("merde2");

		Thread.sleep(10000);
		
		d.update(c);
	}

	
}
