package com.solo.body.user.dao;

import java.util.List;

import com.solo.body.user.model.FamilyMember;
import com.solo.body.user.model.PersonBsics;

public interface PersonBsicsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PersonBsics record);

    int insertSelective(PersonBsics record);

    PersonBsics selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PersonBsics record);

    int updateByPrimaryKey(PersonBsics record);
    
    List<PersonBsics> selectBySql(String sql);
    
    int selectCount(String sql);
}