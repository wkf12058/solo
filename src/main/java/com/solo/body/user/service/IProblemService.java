package com.solo.body.user.service;

import java.util.List;
import java.util.Map;

import com.solo.body.user.model.Problem;

public interface IProblemService {
    int deleteByPrimaryKey(String id);

    int insert(Problem record);

    int insertSelective(Problem record);

    Problem selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Problem record);

    int updateByPrimaryKey(Problem record);
    
    List<Problem> selectBySgin(Map<String, Object> param);
}