package com.solo.body.user.service;

import com.solo.body.user.model.QQuestionType;

public interface IQQuestionTypeService {
    int deleteByPrimaryKey(Integer id);

    int insert(QQuestionType record);

    int insertSelective(QQuestionType record);

    QQuestionType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QQuestionType record);

    int updateByPrimaryKey(QQuestionType record);
}
