package com.solo.body.user.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.solo.body.user.dao.PersonOtherAnswerMapper;
import com.solo.body.user.model.PersonOtherAnswer;
import com.solo.body.user.service.IPersonOtherAnswerService;

@Service
@Transactional
public class PersonOtherAnswerServiceImpl implements IPersonOtherAnswerService {

	
	@Resource
	private PersonOtherAnswerMapper personOtherAnswerMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return personOtherAnswerMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(PersonOtherAnswer record) {
		return personOtherAnswerMapper.insert(record);
	}

	@Override
	public int insertSelective(PersonOtherAnswer record) {
		return personOtherAnswerMapper.insertSelective(record);
	}

	@Override
	public PersonOtherAnswer selectByPrimaryKey(Integer id) {
		return personOtherAnswerMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(PersonOtherAnswer record) {
		return personOtherAnswerMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(PersonOtherAnswer record) {
		return personOtherAnswerMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<PersonOtherAnswer> getByPersonId(String personId) {
		String sql="1=1 and person_id='"+personId+"'";
		return personOtherAnswerMapper.selectBySql(sql);
	}

}
