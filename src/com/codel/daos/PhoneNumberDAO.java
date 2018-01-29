package com.codel.daos;

import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.codel.daos.interfaces.IPhoneNumberDAO;
import com.codel.entities.PhoneNumber;

public class PhoneNumberDAO extends HibernateDaoSupport implements IPhoneNumberDAO{

	
	@Override
	public long save(PhoneNumber entity) {
		return (long) getHibernateTemplate().save(entity);
	}

	@Override
	public void update(PhoneNumber entity) {
		getHibernateTemplate().update(entity);
	}

	@Override
	public PhoneNumber findById(long id) {
		return getHibernateTemplate().get(PhoneNumber.class, id);
	}

	@Override
	public void delete(PhoneNumber entity) {
		getHibernateTemplate().delete(entity);
	}
	
	@Override
	public void delete(long id) {
		getHibernateTemplate().delete(findById(id));
	}
	

	// Utiliser une instance de critéria avec restriction sur l'ordre des resultats 
	@SuppressWarnings("unchecked")
	@Override
	public List<PhoneNumber> findAll() {
		List<PhoneNumber> phoneNumbers =	getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(PhoneNumber.class)
	    .addOrder( Order.asc("phoneNumber") )
	    .list();
		return phoneNumbers;
	}

	// requetes HQL query 
	@Override
	public void deleteAll() {
		getHibernateTemplate().deleteAll(findAll());
	}

}
