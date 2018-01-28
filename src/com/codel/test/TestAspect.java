package com.codel.test;

import org.json.JSONException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.codel.daos.ContactDAO;
import com.codel.daos.ContactGroupDAO;
import com.codel.entities.Address;
import com.codel.entities.Contact;
import com.codel.entities.ContactGroup;

public class TestAspect  {

	public static void main(String[] args) throws JSONException {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//	ContactServices d = (ContactServices) context.getBean("myContactServices");
		//System.out.println(d.updateContact(d.find(1),"firstName", "lastName", "email@gmail.com", "12", "streetType", "streetName", "93000", "city", "country"));
		ContactDAO d = (ContactDAO) context.getBean("myContactDao");
		Contact c1 = new Contact("salism", "SdMAIL", "salim@gail.com", new Address(1, "h", "h", "003", "g", "g"));
		
		ContactGroupDAO cg = (ContactGroupDAO) context.getBean("myContactGroupDAO");
		ContactGroup c2 = new ContactGroup("amis");
		
		c1.addBooks(c2);
		cg.save(c2);
		
	}
	

}