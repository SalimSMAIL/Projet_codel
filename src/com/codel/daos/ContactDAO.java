package com.codel.daos;

import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.codel.daos.interfaces.IContactDAO;
import com.codel.entities.Contact;


public class ContactDAO extends HibernateDaoSupport implements IContactDAO{
	
	@Override
	public long save(Contact entity) {
		return (long) getHibernateTemplate().save(entity);
	}

	@Override
	public void update(Contact entity) {
		getHibernateTemplate().update(entity);
	}

	@Override
	public Contact findById(long id) {
		return getHibernateTemplate().get(Contact.class, id);
	}

	@Override
	public void delete(Contact entity) {
		getHibernateTemplate().delete(entity);
	}
	
	@Override
	public void delete(long id) {
		getHibernateTemplate().execute(session -> {
			String hql = "delete from Contact where contactId= "+id;
			session.createQuery(hql).executeUpdate();
			return null;
		});
	}
	

	// Utiliser une instance de critéria avec restriction sur l'ordre des resultats 
	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> findAll() {
		List<Contact> contacts =	getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(Contact.class)
	    .addOrder( Order.asc("lastName") )
	    .list();
		return contacts;
	}

	// requetes HQL query 
	@Override
	public void deleteAll() {
		getHibernateTemplate().execute(session -> {
			String hql = "delete from Contact";
			session.createQuery(hql).executeUpdate();
			return null;
		});
	}

}
