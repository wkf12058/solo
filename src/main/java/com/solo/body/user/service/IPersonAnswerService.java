package com.solo.body.user.service;

import java.util.Map;

import com.solo.body.user.model.PersonAnswer;

public interface IPersonAnswerService {
    int deleteByPrimaryKey(Integer id);

    int insert(PersonAnswer record);

    int insertSelective(PersonAnswer record);

    PersonAnswer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PersonAnswer record);

    int updateByPrimaryKey(PersonAnswer record);
    
    PersonAnswer getPersonAnwser(Map param);
}