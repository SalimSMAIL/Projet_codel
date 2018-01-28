package com.codel.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.codel.daos.interfaces.IContactGroupDAO;
import com.codel.entities.Contact;
import com.codel.entities.ContactGroup;
import com.codel.utils.HibernateUtility;

public class ContactGroupDAO extends HibernateDaoSupport implements IContactGroupDAO{
	
	@Override
	public long save(Object entity) {
		getHibernateTemplate().save(entity);
		return 0;
	}

	@Override
	public void update(Object entity) {
		this.getHibernateTemplate().update(entity);
		
	}

	@Override
	public Object findById(long id) {
		return getHibernateTemplate().get(ContactGroup.class, 1l);
	}

	@Override
	public void delete(long entity) {
		ContactGroup c = (ContactGroup)findById(entity);
		this.getHibernateTemplate().delete(c);
	}

	@Override
	public List<ContactGroup> findAll() {
		List<ContactGroup> contacts =getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(ContactGroup.class)
			    .addOrder( Order.asc("groupName") )
			    .list();
				return contacts;
	}

	@Override
	public void deleteAll() {
		
	}

}