package com.solo.body.user.service;

import java.util.Map;

import com.solo.body.user.model.PersonInfo;

public interface IPersonInfoService {
    int deleteByPrimaryKey(String id);

    int insert(PersonInfo record);

    int insertSelective(PersonInfo record);

    PersonInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PersonInfo record);

    int updateByPrimaryKey(PersonInfo record);
    
    String inputPersonAllInfo(Map params);
}