package com.codel.test;

import org.json.JSONException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.codel.daos.ContactDAO;
import com.codel.daos.ContactGroupDAO;
import com.codel.daos.PhoneNumberDAO;
import com.codel.entities.Address;
import com.codel.entities.Contact;
import com.codel.entities.ContactGroup;
import com.codel.entities.PhoneNumber;

public class TestAspect  {

	public static void main(String[] args) throws JSONException {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
//	ContactServices d = (ContactServices) context.getBean("myContactServices");
//	System.out.println(d.updateContact(d.find(1),"firstName", "lastName", "email@gmail.com", "12", "streetType", "streetName", "93000", "city", "country"));
//		ContactDAO d = (ContactDAO) context.getBean("myContactDao");
//		Contact c = new Contact("salim", "SMAIL", "salim@gail.com", new Address(0, "h", "h", "003", "g", "g"));
//		Contact c1 = new Contact("salism", "SdMAIL", "salim@gail.com", new Address(1, "h", "h", "003", "g", "g"));
//		ContactGroupDAO cg = (ContactGroupDAO) context.getBean("myContactGroupDAO");
//		ContactGroup c2 = new ContactGroup("amis");
//		cg.save(c2);
//		c1.addBooks(c2);
//		d.save(c1);
//		d.delete(1L);
		
		// phone number supp un phone number
		ContactDAO d = (ContactDAO) context.getBean("myContactDao");
		Contact c = new Contact("salim", "SMAIL", "salim@gail.com", new Address(0, "h", "h", "003", "g", "g"));
		
		PhoneNumberDAO p = (PhoneNumberDAO) context.getBean("myPhoneDao");
		PhoneNumber pn = new PhoneNumber("phoneNumber","phoneKind",c);
		PhoneNumber p1 = new PhoneNumber("bn","mine",c);
		c.addPhone(p1);
		d.save(c);
		
		// supp un contact et verfiei que ça supp tt ses nums
		
//		ContactDAO d = (ContactDAO) context.getBean("myContactDao");
//		Contact c = new Contact("salim", "SMAIL", "salim@gail.com", new Address(0, "h", "h", "003", "g", "g"));
//		
//		PhoneNumberDAO p = (PhoneNumberDAO) context.getBean("myPhoneDao");
//		PhoneNumber pn = new PhoneNumber("phoneNumber","phoneKind",c);
//		PhoneNumber p1 = new PhoneNumber("bn","mine",c);
//		d.save(c);
//		d.delete(1L);
		
		// ze erreur
//		
//		ContactDAO d = (ContactDAO) context.getBean("myContactDao");
//		Contact c1 = new Contact("salism", "SdMAIL", "salim@gail.com", new Address(1, "h", "h", "003", "g", "g"));
//		ContactGroupDAO cg = (ContactGroupDAO) context.getBean("myContactGroupDAO");
//		ContactGroup c2 = new ContactGroup("amis",c1);
//		cg.save(c2);
		
		
		// encore un test
//		ContactDAO d = (ContactDAO) context.getBean("myContactDao");
//		Contact c1 = new Contact("salism", "SdMAIL", "salim@gail.com", new Address(1, "h", "h", "003", "g", "g"));
//		ContactGroupDAO cg = (ContactGroupDAO) context.getBean("myContactGroupDAO");
//		ContactGroup c2 = new ContactGroup("amis");
//		c1.addBooks(c2);
//		d.save(c1);
//		System.out.println(cg.findAll().get(0).getContacts().iterator().next().getFirstName());
		
		
		
		//dernier test
//		ContactDAO d = (ContactDAO) context.getBean("myContactDao");
//		Contact c1 = new Contact("salism", "SdMAIL", "salim@gail.com", new Address(1, "h", "h", "003", "g", "g"));

//		
//		ContactGroupDAO cg = (ContactGroupDAO) context.getBean("myContactGroupDAO");
//		ContactGroup c2 = new ContactGroup("amis");
//
//		c1.addBooks(c2);
//		d.save(c1);
//		
//		c2 = cg.findAll().get(0);		
//		c1= d.findAll().get(0);
//		c1.removeBook(c2);
//		d.update(c1);
		
		
//		ContactDAO d = (ContactDAO) context.getBean("myContactDao");
//		Contact c1 = new Contact("salism", "SdMAIL", "salim@gail.com", new Address(1, "h", "h", "003", "g", "g"));
//		ContactGroupDAO cg = (ContactGroupDAO) context.getBean("myContactGroupDAO");
//		ContactGroup c2 = new ContactGroup("amis");
//		c2.addContact(c1);
//		cg.save(c2);
		
		
//		ContactDAO d = (ContactDAO) context.getBean("myContactDao");
//		Contact c1 = new Contact("salism", "SdMAIL", "salim@gail.com", new Address(1, "h", "h", "003", "g", "g"));
//		
//		PhoneNumber p = new PhoneNumber();
//		p.setPhoneKind("mobile");
//		p.setPhoneNumber("002U5302834");
//
//		c1.addPhone(p);
//
//		System.out.println(p.getContact().getContactId());
//		c1.addPhone(p);
		
		
		
	}
	

}