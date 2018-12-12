package com.solo.body.user.dao;

import java.util.List;

import com.solo.body.user.model.SoUser;
import com.solo.body.user.model.UserAnswer;

public interface UserAnswerMapper {
    int insert(UserAnswer record);

    int insertSelective(UserAnswer record);
    
    List<UserAnswer> selectBySql(String sql);
}