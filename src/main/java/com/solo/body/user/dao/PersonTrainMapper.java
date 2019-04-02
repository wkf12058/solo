package com.solo.body.user.dao;

import java.util.List;

import com.solo.body.user.model.PersonTrain;
import com.solo.body.user.model.PersonWorkExperience;

public interface PersonTrainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PersonTrain record);

    int insertSelective(PersonTrain record);

    PersonTrain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PersonTrain record);

    int updateByPrimaryKey(PersonTrain record);
    
    List<PersonTrain> selectBySql(String sql);
    
    int selectCount(String sql);
}