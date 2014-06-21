package com.saga.model.service;

import java.util.List;

import com.saga.model.dto.HumanResource;

public interface HumanResourceService {
	public void addMemeber(HumanResource hr);
	public List<HumanResource> findAll();
	public void updateMember(HumanResource hr);
	public HumanResource findById(Integer id);
}
