package com.solo.body.user.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.solo.body.user.dao.PersonAnswerMapper;
import com.solo.body.user.model.PersonAnswer;
import com.solo.body.user.service.IPersonAnswerService;

@Service
@Transactional
public class PersonAnswerServiceImpl implements IPersonAnswerService{

	@Resource
	private PersonAnswerMapper personAnswerMapper;
	
	public int deleteByPrimaryKey(Integer id) {
		return personAnswerMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(PersonAnswer record) {
		return personAnswerMapper.insert(record);
	}

	@Override
	public int insertSelective(PersonAnswer record) {
		return personAnswerMapper.insertSelective(record);
	}

	@Override
	public PersonAnswer selectByPrimaryKey(Integer id) {
		return personAnswerMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(PersonAnswer record) {
		return personAnswerMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(PersonAnswer record) {
		return personAnswerMapper.updateByPrimaryKey(record);
	}

}
