package com.codel.daos;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.codel.daos.interfaces.IPhoneNumberDAO;
import com.codel.entities.Contact;
import com.codel.entities.PhoneNumber;

public class PhoneNumberDAO extends HibernateDaoSupport implements IPhoneNumberDAO{

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
		return getHibernateTemplate().get(PhoneNumber.class, 1l);
	}

	@Override
	public void delete(long entity) {
		PhoneNumber c = (PhoneNumber)findById(entity);
		this.getHibernateTemplate().delete(c);
		
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
