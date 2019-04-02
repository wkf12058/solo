package com.solo.body.user.service;

import java.util.List;

import com.solo.body.user.model.PersonOtherAnswer;

public interface IPersonOtherAnswerService {
    int deleteByPrimaryKey(Integer id);

    int insert(PersonOtherAnswer record);

    int insertSelective(PersonOtherAnswer record);

    PersonOtherAnswer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PersonOtherAnswer record);

    int updateByPrimaryKey(PersonOtherAnswer record);
    
    List<PersonOtherAnswer> getByPersonId(String personId);
}