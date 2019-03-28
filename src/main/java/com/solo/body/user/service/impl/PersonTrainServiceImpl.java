package com.solo.body.user.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.solo.body.user.dao.FamilyMemberMapper;
import com.solo.body.user.dao.PersonTrainMapper;
import com.solo.body.user.model.PersonTrain;
import com.solo.body.user.service.IPersonTrainService;

@Service
@Transactional
public class PersonTrainServiceImpl implements IPersonTrainService{

	@Resource
	private PersonTrainMapper personTrainMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return personTrainMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(PersonTrain record) {
		return personTrainMapper.insert(record);
	}

	@Override
	public int insertSelective(PersonTrain record) {
		return personTrainMapper.insertSelective(record);
	}

	@Override
	public PersonTrain selectByPrimaryKey(Integer id) {
		return personTrainMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(PersonTrain record) {
		return personTrainMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(PersonTrain record) {
		return personTrainMapper.updateByPrimaryKey(record);
	}

}
