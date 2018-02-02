package com.codel.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.codel.daos.interfaces.IContactGroupDAO;
import com.codel.entities.Contact;
import com.codel.entities.ContactGroup;

public class ContactGroupDAO extends HibernateDaoSupport implements IContactGroupDAO{

	@Override
	public long save(ContactGroup entity) {
		return (long) getHibernateTemplate().save(entity);
	}

	@Override
	public void update(ContactGroup entity) {
		getHibernateTemplate().update(entity);
	}

	@Override
	public ContactGroup findById(long id) {
		return getHibernateTemplate().get(ContactGroup.class, id);
	}

	@Override
	public void delete(ContactGroup entity) {
		getHibernateTemplate().delete(entity);
	}

	@Override
	public void delete(long id) {
		getHibernateTemplate().delete(findById(id));
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<ContactGroup> findAll() {
		List<ContactGroup> contactGroups =	getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(ContactGroup.class)
				.addOrder( Order.asc("groupName") )
				.list();
		return contactGroups;
	}

	@Override
	public void deleteAll() {
		getHibernateTemplate().deleteAll(findAll());
	}

	public List<Contact> getContacts(long idGroup){
		List contacts =	getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery("SELECT contact_id FROM contact_group_contact WHERE group_id='"+idGroup + "'").list();
		System.out.println("the size :"+contacts.size());
		List<Contact> c = new ArrayList<Contact>();
		for(int i=0;i< contacts.size();i++) {

			c.add((Contact)getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("from Contact c where c.contactId='" + contacts.get(i) + "'").uniqueResult());
		}
		return c;
	}

}