package com.codel.daos.interfaces;

import java.util.List;

public interface IDAO<T> {

	public long save(T entity);
	public void update(T entity);
	public T findById(long id);
	public void delete(T entity);
	public void delete(long id);
	public List<T> findAll();
	public void deleteAll();
	
}
