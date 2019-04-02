package com.solo.body.user.dao;

import java.util.List;

import com.solo.body.user.model.PersonInfo;
import com.solo.body.user.model.QPaper;

public interface PersonInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(PersonInfo record);

    int insertSelective(PersonInfo record);

    PersonInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PersonInfo record);

    int updateByPrimaryKey(PersonInfo record);
    
    List<PersonInfo> selectBySql(String sql);
    
    int selectCount(String sql);
}