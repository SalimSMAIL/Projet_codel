package com.codel.daos;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.codel.daos.interfaces.IContactDAO;
import com.codel.entities.Contact;

public class ContactDAO extends HibernateDaoSupport implements IContactDAO{
	
	SessionFactory sessionFactory;
	
	@Override
	public long save(Object entity) {
		long t = (long) getHibernateTemplate().save(entity);
		return t;
	}

	@Override
	public void update(Object entity) {
		getHibernateTemplate().update(entity);
	}

	@Override
	public Object findById(long id) {
		return getHibernateTemplate().get(Contact.class, 1l);
	}

	@Override
	public void delete(Object entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

}
