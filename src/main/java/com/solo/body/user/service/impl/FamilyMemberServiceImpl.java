package com.solo.body.user.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.solo.body.user.dao.FamilyMemberMapper;
import com.solo.body.user.model.FamilyMember;
import com.solo.body.user.service.IFamilyMemberService;

@Service
@Transactional
public class FamilyMemberServiceImpl implements IFamilyMemberService {

	@Resource
	private FamilyMemberMapper familyMemberMapper;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return familyMemberMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(FamilyMember record) {
		return familyMemberMapper.insert(record);
	}

	@Override
	public int insertSelective(FamilyMember record) {
		return familyMemberMapper.insertSelective(record);
	}

	@Override
	public FamilyMember selectByPrimaryKey(Integer id) {
		return familyMemberMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(FamilyMember record) {
		return familyMemberMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(FamilyMember record) {
		return familyMemberMapper.updateByPrimaryKey(record);
	}
}
