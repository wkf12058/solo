package com.solo.body.user.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.solo.body.user.dao.QQuestionTypeMapper;
import com.solo.body.user.model.QQuestionType;
import com.solo.body.user.service.IQQuestionTypeService;

@Service
@Transactional
public class QQuestionTypeServiceImpl implements IQQuestionTypeService{

	@Resource
	private  QQuestionTypeMapper questionTypeMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return questionTypeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(QQuestionType record) {
		return questionTypeMapper.insert(record);
	}

	@Override
	public int insertSelective(QQuestionType record) {
		return questionTypeMapper.insertSelective(record);
	}

	@Override
	public QQuestionType selectByPrimaryKey(Integer id) {
		return questionTypeMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(QQuestionType record) {
		return questionTypeMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(QQuestionType record) {
		return questionTypeMapper.updateByPrimaryKey(record);
	}

}
