package com.solo.body.user.service;

import java.util.List;
import java.util.Map;

import com.solo.body.user.model.QChoice;
import com.solo.util.mybatis.ResultPage;

public interface IQChoiceService {
    int deleteByPrimaryKey(Integer id);

    int insert(QChoice record);

    int insertSelective(QChoice record);

    QChoice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QChoice record);

    int updateByPrimaryKey(QChoice record);
    
    ResultPage getChoicePage(Map param) ;
    
    List<QChoice> getMoreByIds(String ids) ;
}
