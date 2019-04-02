package com.solo.body.user.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

	@Override
	public PersonAnswer getPersonAnwser(Map param) {
		StringBuilder sql=new StringBuilder("1=1");
		//获取查询条件的关键词
		String paperId=param.get("paperId").toString();
		String personId=param.get("personId").toString();
		sql.append(" and paper_id='"+paperId+"'" );
		sql.append(" and person_id='"+personId+"'" );
		List<PersonAnswer> list=personAnswerMapper.selectBySql(sql.toString());
		PersonAnswer item=new PersonAnswer();
		if(list.size()>0){
			 item=list.get(0);
		}
		return item;
	}

}
