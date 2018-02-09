package com.solo.body.user.service;

import com.solo.body.user.model.User;


public interface IUserService {
	
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User selectByUserId(String userId);
}
