package com.solo.body.user.dao;

import com.solo.body.user.model.PersonAnswer;

public interface PersonAnswerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PersonAnswer record);

    int insertSelective(PersonAnswer record);

    PersonAnswer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PersonAnswer record);

    int updateByPrimaryKey(PersonAnswer record);
}