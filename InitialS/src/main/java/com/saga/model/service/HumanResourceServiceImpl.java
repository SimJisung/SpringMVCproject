package com.saga.model.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.saga.model.dao.HumanResourceDao;
import com.saga.model.dto.HumanResource;
@Service("humanResourceService")
public class HumanResourceServiceImpl implements HumanResourceService {
	
	@Autowired
	HumanResourceDao humanResourceDao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addMemeber(HumanResource hr) {
		humanResourceDao.addMember(hr);
	}

	@Override
	@Transactional(readOnly = true)
	public List<HumanResource> findAll() {
		return humanResourceDao.findAll();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateMember(HumanResource hr) {
		humanResourceDao.updateMember(hr);
	}

	@Override
	@Transactional(readOnly = true)
	public HumanResource findById(Integer id) {
		return humanResourceDao.findById(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteMember(HumanResource hr) {
		humanResourceDao.deleteMember(hr);
	}
	
	
	
}
