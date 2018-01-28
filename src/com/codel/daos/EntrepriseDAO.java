package com.codel.daos;

import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.codel.daos.interfaces.IEntrepriseDAO;
import com.codel.entities.Entreprise;

public class EntrepriseDAO extends HibernateDaoSupport implements IEntrepriseDAO{

	
	@Override
	public long save(Entreprise entity) {
		return (long) getHibernateTemplate().save(entity);
	}

	@Override
	public void update(Entreprise entity) {
		getHibernateTemplate().update(entity);
	}

	@Override
	public Entreprise findById(long id) {
		return getHibernateTemplate().get(Entreprise.class, id);
	}

	@Override
	public void delete(Entreprise entity) {
		getHibernateTemplate().delete(entity);
	}
	
	@Override
	public void delete(long id) {
		getHibernateTemplate().execute(session -> {
			String hql = "delete from Entreprise where contactId= "+id;
			session.createQuery(hql).executeUpdate();
			return null;
		});
	}
	

	// Utiliser une instance de critéria avec restriction sur l'ordre des resultats 
	@SuppressWarnings("unchecked")
	@Override
	public List<Entreprise> findAll() {
		List<Entreprise> entreprises =	getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(Entreprise.class)
	    .addOrder( Order.asc("groupName") )
	    .list();
		return entreprises;
	}

	// requetes HQL query 
	@Override
	public void deleteAll() {
		getHibernateTemplate().execute(session -> {
			String hql = "delete from Entreprise";
			session.createQuery(hql).executeUpdate();
			return null;
		});
	}

}
