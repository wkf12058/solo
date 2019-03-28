package com.solo.body.user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.solo.body.user.model.QChoice;

public interface QChoiceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QChoice record);

    int insertSelective(QChoice record);

    QChoice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QChoice record);

    int updateByPrimaryKey(QChoice record);
    
    List<QChoice> selectBySql(String sql);
    
    int selectCount(String sql);
}