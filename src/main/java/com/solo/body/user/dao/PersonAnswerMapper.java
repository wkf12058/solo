package com.solo.body.user.dao;

import java.util.List;

import com.solo.body.user.model.PersonAnswer;
import com.solo.body.user.model.QPaper;

public interface PersonAnswerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PersonAnswer record);

    int insertSelective(PersonAnswer record);

    PersonAnswer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PersonAnswer record);

    int updateByPrimaryKey(PersonAnswer record);
    
    List<PersonAnswer> selectBySql(String sql);
    
    int selectCount(String sql);
}