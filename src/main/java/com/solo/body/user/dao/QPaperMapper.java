package com.solo.body.user.dao;

import java.util.List;

import com.solo.body.user.model.QChoice;
import com.solo.body.user.model.QPaper;

public interface QPaperMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QPaper record);

    int insertSelective(QPaper record);

    QPaper selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QPaper record);

    int updateByPrimaryKey(QPaper record);
    
    List<QPaper> selectBySql(String sql);
    
    int selectCount(String sql);
}