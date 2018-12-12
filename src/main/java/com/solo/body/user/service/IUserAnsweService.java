package com.solo.body.user.service;

import java.util.List;

import com.solo.body.user.model.UserAnswer;

public interface IUserAnsweService {
    int insert(UserAnswer record);

    int insertSelective(UserAnswer record);
    
    List<UserAnswer> selectBySql(String sql);
}