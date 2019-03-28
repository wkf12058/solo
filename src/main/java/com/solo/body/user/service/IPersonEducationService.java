package com.solo.body.user.service;

import com.solo.body.user.model.PersonEducation;

public interface IPersonEducationService {
    int deleteByPrimaryKey(Integer id);

    int insert(PersonEducation record);

    int insertSelective(PersonEducation record);

    PersonEducation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PersonEducation record);

    int updateByPrimaryKey(PersonEducation record);
}