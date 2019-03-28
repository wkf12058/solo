package com.solo.body.user.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.solo.body.user.dao.PersonEducationMapper;
import com.solo.body.user.dao.PersonInfoMapper;
import com.solo.body.user.model.PersonEducation;
import com.solo.body.user.service.IPersonEducationService;

@Service
@Transactional
public class PersonEducationServiceImpl implements IPersonEducationService{

	
	@Resource
	private PersonEducationMapper personEducationMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return personEducationMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(PersonEducation record) {
		return personEducationMapper.insert(record);
	}

	@Override
	public int insertSelective(PersonEducation record) {
		return personEducationMapper.insertSelective(record);
	}

	@Override
	public PersonEducation selectByPrimaryKey(Integer id) {
		return personEducationMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(PersonEducation record) {
		return personEducationMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(PersonEducation record) {
		return personEducationMapper.updateByPrimaryKey(record);
	}

}
