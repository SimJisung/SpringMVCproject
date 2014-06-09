/**
 * 
 */
package com.saga.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 * @author simjisung
 *
 */
public class HibernateSessionFactoryImpl implements HibernateSessionFactory {
	
	@Autowired
	protected SessionFactory sessionFactory;
	
	
	/*
	@Autowired
	@PersistenceContext
	protected EntityManager entityManager;
	*/
	
	/*
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	*
	/*
	public void setEntityManager(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	*/
}
