package com.solo.body.user.dao;

import com.solo.body.user.model.PersonConsultant;

public interface PersonConsultantMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PersonConsultant record);

    int insertSelective(PersonConsultant record);

    PersonConsultant selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PersonConsultant record);

    int updateByPrimaryKey(PersonConsultant record);
}