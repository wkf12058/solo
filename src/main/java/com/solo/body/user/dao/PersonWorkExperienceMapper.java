package com.solo.body.user.dao;

import java.util.List;

import com.solo.body.user.model.PersonWorkExperience;
import com.solo.body.user.model.QChoice;

public interface PersonWorkExperienceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PersonWorkExperience record);

    int insertSelective(PersonWorkExperience record);

    PersonWorkExperience selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PersonWorkExperience record);

    int updateByPrimaryKey(PersonWorkExperience record);
    
    List<PersonWorkExperience> selectBySql(String sql);
    
    int selectCount(String sql);
}