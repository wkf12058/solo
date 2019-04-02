package com.solo.body.user.dao;

import java.util.List;

import com.solo.body.user.model.PersonOtherAnswer;
import com.solo.body.user.model.QChoice;

public interface PersonOtherAnswerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PersonOtherAnswer record);

    int insertSelective(PersonOtherAnswer record);

    PersonOtherAnswer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PersonOtherAnswer record);

    int updateByPrimaryKey(PersonOtherAnswer record);
    
    List<PersonOtherAnswer> selectBySql(String sql);
    
    int selectCount(String sql);
}