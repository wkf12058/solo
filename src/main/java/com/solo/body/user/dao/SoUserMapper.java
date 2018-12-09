package com.solo.body.user.dao;

import java.util.List;

import com.solo.body.user.model.Problem;
import com.solo.body.user.model.SoUser;

public interface SoUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SoUser record);

    int insertSelective(SoUser record);

    SoUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SoUser record);

    int updateByPrimaryKey(SoUser record);
    
    List<SoUser> selectBySql(String sql);
}