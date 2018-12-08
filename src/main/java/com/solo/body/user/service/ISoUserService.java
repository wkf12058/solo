package com.solo.body.user.service;

import com.solo.body.user.model.SoUser;

public interface ISoUserService {
    int deleteByPrimaryKey(Integer id);

    int insert(SoUser record);

    int insertSelective(SoUser record);

    SoUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SoUser record);

    int updateByPrimaryKey(SoUser record);
    
    SoUser getUserByOpenId(String openId);
}