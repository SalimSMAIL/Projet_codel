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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(Object entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ContactGroup> findAll() {
		List<ContactGroup> contacts =getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(ContactGroup.class)
			    .addOrder( Order.asc("firstName") )
			    .list();
				return contacts;
	}

	@Override
	public void deleteAll() {
		
	}

}
