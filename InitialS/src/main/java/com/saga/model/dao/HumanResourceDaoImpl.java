package com.saga.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.saga.model.dto.HumanResource;

@Repository("humanResourceDao")
public class HumanResourceDaoImpl extends HibernateSessionFactoryImpl implements HumanResourceDao{

	public void addMember(HumanResource hr){
		Session session = sessionFactory.getCurrentSession();
		session.save(hr);
	}

	@Override
	public List<HumanResource> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List<HumanResource> list = session.createCriteria(HumanResource.class).list();
		return list;
	}
}
