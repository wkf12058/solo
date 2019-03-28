package com.solo.body.user.dao;

import com.solo.body.user.model.QQuestionType;

public interface QQuestionTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QQuestionType record);

    int insertSelective(QQuestionType record);

    QQuestionType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QQuestionType record);

    int updateByPrimaryKey(QQuestionType record);
}