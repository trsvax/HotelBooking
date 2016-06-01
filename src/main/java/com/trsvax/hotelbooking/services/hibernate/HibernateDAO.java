package com.trsvax.hotelbooking.services.hibernate;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.hibernate.Query;
import org.hibernate.Session;

import com.trsvax.hotelbooking.services.DAO;

/**
 * Shim for Hibernate 4 to allow generic database access. Should also work with Hobernate 5
 * 
 * @author bfb
 *
 */
public class HibernateDAO implements DAO {
	
	private final Session session;
		
	public HibernateDAO (Session session) {
		this.session = session;
	}
	
	public void save(Object entity) {
		session.persist(entity);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <E> E findById(Class<E> entityClass, Serializable id, boolean lock) {
		return (E) session.load(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <E> List<E> findAll(Class<E> entityClass) {
		return session.createCriteria(entityClass).list();	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <E> List<E> query(Class<E> clazz, String queryString, Object ... parameters )  {
		return addParameters(session.createQuery(queryString), parameters).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <E> E findByQuery(Class<E> clazz, String queryString, Object ... parameters )  {
		return (E) addParameters(session.createQuery(queryString), parameters).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <E> List<E> namedQuery(Class<E> clazz, String queryName, Object ... parameters )  {
		return addParameters(session.getNamedQuery(queryName), parameters).list();
	}
	
	@SuppressWarnings("unchecked")
	public <E> E findByNamedQuery(Class<E> clazz, String queryName, Object ... parameters )  {
		return (E) addParameters(session.getNamedQuery(queryName),parameters).uniqueResult();
	}
	
	Query addParameters(Query query, Object[] parameters) {		
		map(parameters).entrySet().stream().forEach(e->query.setParameter(e.getKey(),e.getValue()));	
		return query;
	}
	
	Map<String,Object> map(Object[] parameters) {	
		return Stream.iterate(Arrays.asList(parameters), l -> l.subList(2, l.size()))
		            .limit(parameters.length / 2)
		            .collect(Collectors.toMap(l -> (String) l.get(0), l -> l.get(1)));				
	}

}
