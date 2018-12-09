package com.solo.body.user.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.solo.body.user.dao.ProblemMapper;
import com.solo.body.user.dao.UserMapper;
import com.solo.body.user.model.Problem;
import com.solo.body.user.service.IProblemService;


@Service
@Transactional
public class ProblemServiceImpl implements IProblemService{

	
	@Resource
	private ProblemMapper problemMapper;
	
	@Override
	public int deleteByPrimaryKey(String id) {
		return problemMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Problem record) {
		return problemMapper.insert(record);
	}

	@Override
	public int insertSelective(Problem record) {
		return problemMapper.insertSelective(record);
	}

	@Override
	public Problem selectByPrimaryKey(String id) {
		return problemMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Problem record) {
		return problemMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Problem record) {
		return problemMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Problem> selectBySgin(Map<String, Object> param) {
		String sql="1=1 ";
		String sign=param.get("sign").toString();
		sql +="and  sign='"+sign+"' ";
		System.err.println(sql);
		return problemMapper.selectBySql(sql);
	}
	
	
}