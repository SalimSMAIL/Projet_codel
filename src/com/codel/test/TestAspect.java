package com.codel.test;

import org.json.JSONException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.codel.daos.ContactDAO;
import com.codel.daos.PhoneNumberDAO;
import com.codel.entities.Address;
import com.codel.entities.Contact;
import com.codel.entities.PhoneNumber;

public class TestAspect  {

	public static void main(String[] args) throws JSONException {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//	ContactServices d = (ContactServices) context.getBean("myContactServices");
		//System.out.println(d.updateContact(d.find(1),"firstName", "lastName", "email@gmail.com", "12", "streetType", "streetName", "93000", "city", "country"));
//		ContactDAO d = (ContactDAO) context.getBean("myContactDao");
//		Contact c = new Contact("salim", "SMAIL", "salim@gail.com", new Address(0, "h", "h", "003", "g", "g"));
//		Contact c1 = new Contact("salism", "SdMAIL", "salim@gail.com", new Address(1, "h", "h", "003", "g", "g"));
//		ContactGroupDAO cg = (ContactGroupDAO) context.getBean("myContactGroupDAO");
//		ContactGroup c2 = new ContactGroup("amis");
//		cg.save(c2);
//		c1.addBooks(c2);
//		d.save(c1);
//		d.delete(1L);
		ContactDAO d = (ContactDAO) context.getBean("myContactDao");
		Contact c = new Contact("salim", "SMAIL", "salim@gail.com", new Address(0, "h", "h", "003", "g", "g"));
		d.save(c);
		PhoneNumberDAO p = (PhoneNumberDAO) context.getBean("myPhoneDao");
		PhoneNumber pn = new PhoneNumber("phoneNumber","phoneKind",c);
		p.save(pn);
		
		
	}
	

}