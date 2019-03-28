package com.solo.body.user.dao;

import com.solo.body.user.model.PersonTrain;

public interface PersonTrainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PersonTrain record);

    int insertSelective(PersonTrain record);

    PersonTrain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PersonTrain record);

    int updateByPrimaryKey(PersonTrain record);
}