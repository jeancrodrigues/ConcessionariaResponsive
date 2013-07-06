package com.jree.rentstore.dao;

import java.util.List;

public interface IConcessionariaBaseDAO<T> {
	public T save(T object);
	public T get(int primaryKey);
	public void update(T object);
	public void delete(T object);
	public List<T> listAll();	
}
