package com.trsvax.hotelbooking.services;

import java.io.Serializable;
import java.util.List;

/**
 * Provides type safe access to database objects with a generic interface that should
 * be portable across different libraries.
 * 
 * @author bfb
 *
 */
public interface DAO {
	
	/**
	 * Just saves the entity
	 * 
	 * @param enitty
	 */
	public void save(Object enitty);

	/**
	 * Find one entity object by it's primary key
	 * 
	 * @param clazz
	 * @param id
	 * @param lock
	 * @return entity
	 */
	public <E> E findById(Class<E> clazz, Serializable id, boolean lock);
	
	/**
	 * Returns all entities of for the given class
	 * 
	 * @param clazz
	 * @return List of entities
	 */
	public <E> List<E> findAll(Class<E> clazz);
	
	/**
	 * Finds one entity using the provided query and the objects as name/value query parameters
	 * 
	 * @param clazz
	 * @param queryString
	 * @param objects
	 * @return one entity
	 */
	public <E> E findByQuery(Class<E> clazz, String queryString, Object ... objects );
	
	/**
	 * Finds all entities using the provided query and the objects as name/value query parameters
	 * 
	 * @param clazz
	 * @param queryString
	 * @param objects
	 * @return List of entities
	 */
	public <E> List<E> query(Class<E> clazz, String queryString, Object ... objects );
	
	/**
	 * Finds one entity using the named query and the objects as name/value query parameters
	 * 
	 * @param clazz
	 * @param queryName
	 * @param objects
	 * @return one entity
	 */
	public <E> List<E> namedQuery(Class<E> clazz, String queryName, Object ... objects );
	
	/**
	 * Finds all entities using the named query and the objects as name/value query parameters
	 * 
	 * @param clazz
	 * @param queryName
	 * @param objects
	 * @return List of entities
	 */
	public <E> E findByNamedQuery(Class<E> clazz, String queryName, Object ... objects );
		
}
