package com.codel.daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.codel.daos.interfaces.IContactDAO;
import com.codel.entities.Contact;
import com.codel.utils.HibernateUtility;


public class ContactDAO extends HibernateDaoSupport implements IContactDAO{
	
	//
	
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
		return getHibernateTemplate().get(Contact.class, id);
	}

	@Override
	public void delete(long entity) {
		Contact c = (Contact)findById(entity);
		this.getHibernateTemplate().delete(c);
	}
	

	// Utiliser une instance de critéria avec restriction sur l'ordre des resultats 
	@Override
	public List<Contact> findAll() {
		List<Contact> contacts =	getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(Contact.class)
	    .addOrder( Order.asc("firstName") )
	    .list();
		return contacts;
	}

	// requetes HQL query 
	@Override
	public void deleteAll() {
		getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("DELETE FROM Contact").executeUpdate();
	}

}
