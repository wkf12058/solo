package com.solo.body.user.dao;

import java.util.List;

import com.solo.body.user.model.FamilyMember;
import com.solo.body.user.model.QChoice;

public interface FamilyMemberMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FamilyMember record);

    int insertSelective(FamilyMember record);

    FamilyMember selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FamilyMember record);

    int updateByPrimaryKey(FamilyMember record);
    
    List<FamilyMember> selectBySql(String sql);
    
    int selectCount(String sql);
    
}