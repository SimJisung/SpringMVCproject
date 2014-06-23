package com.saga.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.saga.model.dto.HumanResource;

/**
 * 
 * @author simjisung
 *
 *@Repository - 데이터 입력에 문제가 발생할 경우, 이 애노테이션을 쓰면 자동적으로 DataAccessException 을 떨어뜨리게 된다. 
 */
@Repository("humanResourceDao")
public class HumanResourceDaoImpl extends HibernateSessionFactoryImpl implements HumanResourceDao{

	public void addMember(HumanResource hr){
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(hr);
	}

	@Override
	public List<HumanResource> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List<HumanResource> list = session.createCriteria(HumanResource.class).list();
		return list;
	}

	@Override
	public void updateMember(HumanResource hr) {
		Session session = sessionFactory.getCurrentSession();
		session.update(hr);
	}

	@Override
	public HumanResource findById(Integer id) {
		Session session = sessionFactory.getCurrentSession();	
		Criteria criteria = session.createCriteria(HumanResource.class);
		criteria.add(Restrictions.eq("id", id));
		HumanResource hr = (HumanResource) criteria.uniqueResult();
		//HumanResource hr = (HumanResource) session.load(HumanResource.class,id);
		//System.out.println("DAO : "+hr);
		return hr;
	}

	@Override
	public void deleteMember(HumanResource hr) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(hr);
	}
}
