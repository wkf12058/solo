package com.solo.body.user.service;

import java.util.List;
import java.util.Map;

import com.solo.body.user.model.MainShow;
import com.solo.body.user.model.PersonAnswer;
import com.solo.body.user.model.PersonInfo;
import com.solo.util.mybatis.ResultPage;

public interface IPersonInfoService {
    int deleteByPrimaryKey(String id);

    int insert(PersonInfo record);

    int insertSelective(PersonInfo record);

    PersonInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PersonInfo record);

    int updateByPrimaryKey(PersonInfo record);
    
    String inputPersonAllInfo(Map params);
    
    ResultPage getPaperPage(Map param) ;
    
    Map<String,Object> getPersonInfoById(String personId) ;
   
}