package com.solo.body.user.dao;

import java.util.List;

import com.solo.body.user.model.PersonEducation;
import com.solo.body.user.model.PersonTrain;

public interface PersonEducationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PersonEducation record);

    int insertSelective(PersonEducation record);

    PersonEducation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PersonEducation record);

    int updateByPrimaryKey(PersonEducation record);
    
    List<PersonEducation> selectBySql(String sql);
    
    int selectCount(String sql);
}