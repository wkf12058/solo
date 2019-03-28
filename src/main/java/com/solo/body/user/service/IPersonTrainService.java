package com.solo.body.user.service;

import com.solo.body.user.model.PersonTrain;

public interface IPersonTrainService {
    int deleteByPrimaryKey(Integer id);

    int insert(PersonTrain record);

    int insertSelective(PersonTrain record);

    PersonTrain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PersonTrain record);

    int updateByPrimaryKey(PersonTrain record);
}