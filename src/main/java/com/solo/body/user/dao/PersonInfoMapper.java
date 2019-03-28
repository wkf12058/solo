package com.solo.body.user.dao;

import com.solo.body.user.model.PersonInfo;

public interface PersonInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(PersonInfo record);

    int insertSelective(PersonInfo record);

    PersonInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PersonInfo record);

    int updateByPrimaryKey(PersonInfo record);
}