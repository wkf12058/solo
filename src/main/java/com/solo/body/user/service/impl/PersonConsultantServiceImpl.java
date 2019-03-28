package com.solo.body.user.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.solo.body.user.model.FamilyMember;
import com.solo.body.user.model.PersonConsultant;
import com.solo.body.user.service.IPersonConsultantService;

@Service
@Transactional
public class PersonConsultantServiceImpl implements IPersonConsultantService{

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return 0;
	}

	@Override
	public int insert(FamilyMember record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(FamilyMember record) {
		return 0;
	}

	@Override
	public FamilyMember selectByPrimaryKey(Integer id) {
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(FamilyMember record) {
		return 0;
	}

	@Override
	public int updateByPrimaryKey(FamilyMember record) {
		return 0;
	}

}