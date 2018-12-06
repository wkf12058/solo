package com.solo.body.user.dao;

import java.util.List;
import java.util.Map;

import com.solo.body.user.model.Problem;

public interface ProblemMapper {
    int deleteByPrimaryKey(String id);

    int insert(Problem record);

    int insertSelective(Problem record);

    Problem selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Problem record);

    int updateByPrimaryKey(Problem record);
    
    List<Problem> selectBySql(String sql);
}