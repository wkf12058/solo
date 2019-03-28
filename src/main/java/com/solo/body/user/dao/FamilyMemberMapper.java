package com.solo.body.user.dao;

import com.solo.body.user.model.FamilyMember;

public interface FamilyMemberMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FamilyMember record);

    int insertSelective(FamilyMember record);

    FamilyMember selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FamilyMember record);

    int updateByPrimaryKey(FamilyMember record);
}