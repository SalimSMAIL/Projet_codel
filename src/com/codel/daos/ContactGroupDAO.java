package com.codel.daos;

import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.codel.daos.interfaces.IContactGroupDAO;
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
		getHibernateTemplate().execute(session -> {
			String hql = "delete from ContactGroup where contactId= "+id;
			session.createQuery(hql).executeUpdate();
			return null;
		});
	}
	

	// Utiliser une instance de critéria avec restriction sur l'ordre des resultats 
	@SuppressWarnings("unchecked")
	@Override
	public List<ContactGroup> findAll() {
		List<ContactGroup> contactGroups =	getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(ContactGroup.class)
	    .addOrder( Order.asc("groupName") )
	    .list();
		return contactGroups;
	}

	// requetes HQL query 
	@Override
	public void deleteAll() {
		getHibernateTemplate().execute(session -> {
			String hql = "delete from ContactGroup";
			session.createQuery(hql).executeUpdate();
			return null;
		});
	}

}