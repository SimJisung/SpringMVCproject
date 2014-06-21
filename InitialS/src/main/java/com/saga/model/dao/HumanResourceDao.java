package com.saga.model.dao;

import java.util.List;

import com.saga.model.dto.HumanResource;

public interface HumanResourceDao extends HibernateSessionFactory{
	public void addMember(HumanResource hr);
	public List<HumanResource> findAll();
	public void updateMember(HumanResource hr);
	public HumanResource findById(Integer id);
}
