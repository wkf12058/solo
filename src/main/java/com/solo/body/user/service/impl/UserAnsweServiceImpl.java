package com.solo.body.user.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.solo.body.user.dao.UserAnswerMapper;
import com.solo.body.user.dao.UserMapper;
import com.solo.body.user.model.User;
import com.solo.body.user.model.UserAnswer;
import com.solo.body.user.service.IUserAnsweService;
import com.solo.body.user.service.IUserService;


@Service
@Transactional
public class UserAnsweServiceImpl  implements IUserAnsweService {

	@Resource
	private UserAnswerMapper userAnswerMapper;
	
	@Override
	public int insert(UserAnswer record) {
		return userAnswerMapper.insert(record);
	}

	@Override
	public int insertSelective(UserAnswer record) {
		return userAnswerMapper.insertSelective(record);
	}

	@Override
	public List<UserAnswer> selectBySql(String sql) {
		return userAnswerMapper.selectBySql(sql);
	}


}
