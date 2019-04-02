package com.solo.body.user.dao;

import java.util.List;

import com.solo.body.user.model.FamilyMember;
import com.solo.body.user.model.MainShow;

public interface MainShowMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MainShow record);

    int insertSelective(MainShow record);

    MainShow selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MainShow record);

    int updateByPrimaryKey(MainShow record);
    
    List<MainShow> selectBySql(String sql);
    
    int selectCount(String sql);
}