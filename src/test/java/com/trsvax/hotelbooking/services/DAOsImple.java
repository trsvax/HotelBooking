package com.trsvax.hotelbooking.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DAOsImple implements DAO {
	
	private final Map<Class<?>,List<Object>> entities = new HashMap<Class<?>,List<Object>>();
	
	public DAOsImple(Object ... entities) {
		for ( Object entity : entities ) {
			save(entity);
		}
	}

	public DAOsImple() {
	}

	@Override
	public void save(Object entity) {
		List<Object> list = entities.get(entity.getClass());
		if ( list == null ) {
			list = new ArrayList<>();
			entities.put(entity.getClass(), list);
		}
		list.add(entity);
	}
	
	private <E> E one(Class<E> clazz) {
		List<E> l =  many(clazz);
		if ( l.isEmpty() ) {
			return null;
		}
		return l.get(0);
	}
	
	private <E> List<E> many(Class<E> clazz) {
		@SuppressWarnings("unchecked")
		List<E> l =  (List<E>) entities.get(clazz);
		if ( l == null ) {
			return Collections.emptyList();
		}
		return l;
	}

	@Override	
	public <E> E findById(Class<E> clazz, Serializable id, boolean lock) {
		return one(clazz);
	}

	@Override
	public <E> List<E> findAll(Class<E> clazz) {
		return many(clazz);
	}

	@Override
	public <E> E findByQuery(Class<E> clazz, String queryString, Object... objects) {
		return one(clazz);	
	}

	@Override
	public <E> List<E> query(Class<E> clazz, String queryString, Object... objects) {
		return many(clazz);
	}

	@Override
	public <E> List<E> namedQuery(Class<E> clazz, String queryName, Object... objects) {
		return many(clazz);
	}

	@Override
	public <E> E findByNamedQuery(Class<E> clazz, String queryName, Object... objects) {
		return one(clazz);
	}

}
