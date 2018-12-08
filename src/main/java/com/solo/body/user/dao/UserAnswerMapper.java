package com.solo.body.user.dao;

import com.solo.body.user.model.UserAnswer;

public interface UserAnswerMapper {
    int insert(UserAnswer record);

    int insertSelective(UserAnswer record);
}