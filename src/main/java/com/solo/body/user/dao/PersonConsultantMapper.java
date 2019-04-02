package com.solo.body.user.dao;

import java.util.List;

import com.solo.body.user.model.PersonConsultant;
import com.solo.body.user.model.QChoice;

public interface PersonConsultantMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PersonConsultant record);

    int insertSelective(PersonConsultant record);

    PersonConsultant selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PersonConsultant record);

    int updateByPrimaryKey(PersonConsultant record);
    
    List<PersonConsultant> selectBySql(String sql);
    
    int selectCount(String sql);
}