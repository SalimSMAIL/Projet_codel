package com.codel.daos;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> findAll() {
		List<Contact> contacts =	getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(Contact.class)
	    .addOrder( Order.asc("firstName") )
	    .list();
		return contacts;
	}

	@Override
	public void deleteAll() {
		getHibernateTemplate().deleteAll(findAll());
	}
	

//	public void addContactToGroup() {
//		getHibernateTemplate().deleteAll(findAll());
//	}
	
	public List<Contact> searchContact(String search) {
		List<Contact> contacts =getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(Contact.class)
				.add(Restrictions.like("firstName", "%"+search+"%")).list();
		contacts.addAll(getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(Contact.class).add(Restrictions.like("lastName", "%"+search+"%")).list());
		contacts.addAll(getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(Contact.class).add(Restrictions.like("email", "%"+search+"%")).list());
		Set<Contact> setContact = new HashSet<>();
		setContact.addAll(contacts);
		contacts.clear();
		contacts.addAll(setContact);
		return contacts;
	}
	

}
