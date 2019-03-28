package com.solo.body.user.service;

import java.util.List;
import java.util.Map;

import com.solo.body.user.model.QPaper;
import com.solo.util.mybatis.ResultPage;

public interface IQPaperService {
    int deleteByPrimaryKey(Integer id);

    int insert(QPaper record);

    int insertSelective(QPaper record);

    QPaper selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QPaper record);

    int updateByPrimaryKey(QPaper record);
    
    ResultPage getPaperPage(Map param) ;
    
    
}
