package com.solo.body.user.dao;

import com.solo.body.user.model.PersonEducation;

public interface PersonEducationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PersonEducation record);

    int insertSelective(PersonEducation record);

    PersonEducation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PersonEducation record);

    int updateByPrimaryKey(PersonEducation record);
}