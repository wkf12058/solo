package com.solo.body.user.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.solo.body.user.dao.SoUserMapper;
import com.solo.body.user.dao.UserMapper;
import com.solo.body.user.model.SoUser;
import com.solo.body.user.model.User;
import com.solo.body.user.service.ISoUserService;
import com.solo.body.user.service.IUserService;


@Service
@Transactional
public class SoUserServiceImpl  implements ISoUserService {
	
	@Resource
	private SoUserMapper soUserMapper;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return soUserMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SoUser record) {
		return soUserMapper.insert(record);
	}

	@Override
	public int insertSelective(SoUser record) {
		return soUserMapper.insertSelective(record);
	}

	@Override
	public SoUser selectByPrimaryKey(Integer id) {
		return soUserMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(SoUser record) {
		return soUserMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SoUser record) {
		return soUserMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<SoUser> getUserByOpenId(String openId) {
		String sql="1=1 ";
		sql +="and open_id='"+openId+"' ";
		return soUserMapper.selectBySql(sql);
	}


}
