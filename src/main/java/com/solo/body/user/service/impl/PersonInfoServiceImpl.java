package com.solo.body.user.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.solo.body.user.dao.FamilyMemberMapper;
import com.solo.body.user.dao.PersonConsultantMapper;
import com.solo.body.user.dao.PersonEducationMapper;
import com.solo.body.user.dao.PersonInfoMapper;
import com.solo.body.user.dao.PersonTrainMapper;
import com.solo.body.user.dao.PersonWorkExperienceMapper;
import com.solo.body.user.dao.MainShowMapper;
import com.solo.body.user.model.FamilyMember;
import com.solo.body.user.model.MainShow;
import com.solo.body.user.model.PersonAnswer;
import com.solo.body.user.model.PersonConsultant;
import com.solo.body.user.model.PersonEducation;
import com.solo.body.user.model.PersonInfo;
import com.solo.body.user.model.PersonTrain;
import com.solo.body.user.model.PersonWorkExperience;
import com.solo.body.user.model.QPaper;
import com.solo.body.user.service.IFamilyMemberService;
import com.solo.body.user.service.IPersonConsultantService;
import com.solo.body.user.service.IPersonEducationService;
import com.solo.body.user.service.IPersonInfoService;
import com.solo.body.user.service.IPersonTrainService;
import com.solo.util.mybatis.ResultPage;
import com.solo.util.mybatis.SqlUtil;

@Service
@Transactional
public class PersonInfoServiceImpl implements IPersonInfoService{

	@Resource
	private PersonInfoMapper personInfoMapper;
	
	@Resource
	private FamilyMemberMapper familyMemberMapper;//家庭成员
	@Resource
	private PersonEducationMapper personEducationMapper;//学历
	@Resource
	private PersonTrainMapper personTrainMapper;//培训经历
	@Resource
	private PersonConsultantMapper personConsultantMapper;//背景调查联系人
	@Resource
	private  PersonWorkExperienceMapper personWorkExperience;//工作经验
	
	@Override
	public int deleteByPrimaryKey(String id) {
		return personInfoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(PersonInfo record) {
		return personInfoMapper.insert(record);
	}

	@Override
	public int insertSelective(PersonInfo record) {
		return personInfoMapper.insertSelective(record);
	}

	@Override
	public PersonInfo selectByPrimaryKey(String id) {
		return personInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(PersonInfo record) {
		return personInfoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(PersonInfo record) {
		return personInfoMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public String inputPersonAllInfo(Map params) {
		
		//个人
		PersonInfo personInfo=new PersonInfo();
		personInfo.getPropertyThroughMap(params);
		
		int machineId = 1;
		//String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if(hashCodeV < 0) {//有可能是负数
            hashCodeV = - hashCodeV;
        }
        String uuid= machineId + String.format("%015d", hashCodeV);
		
		personInfo.setId(uuid);
		personInfo.setInputTime(new Date());
		personInfoMapper.insert(personInfo);
		//学历
		String education=params.get("education").toString();
		JSONArray educationList = JSONArray.parseArray(education);
		//List<PersonEducation> eList=new ArrayList<>();
		if(educationList.size()>0){
			for (int i = 0; i < educationList.size(); i++) {
				PersonEducation record=new PersonEducation();
				 JSONObject item = educationList.getJSONObject(i);
				 record.setPersonId(uuid);
				 record.setMajor(item.get("major").toString());
				 record.setCertificate(item.get("certificate").toString());
				 record.setSchoolName(item.get("schoolName").toString());
				 record.setTimeSlot(item.get("timeSlot").toString());
				 record.setEducation(item.get("education").toString());
				 //eList.add(record);
				 personEducationMapper.insert(record);
			}
		}
		
		
		//家庭成员
		String family=params.get("family").toString();
		JSONArray familyList = JSONArray.parseArray(family);
		//List<FamilyMember> fList=new ArrayList<>();
		if(familyList.size()>0){
			for (int i = 0; i < familyList.size(); i++) {
				FamilyMember record=new FamilyMember();
				 JSONObject item = familyList.getJSONObject(i);
				 record.setPersonId(uuid);
				 record.setBirthday(item.get("birthday").toString());
				 record.setJob(item.get("job").toString());
				 record.setName(item.get("name").toString());
				 record.setRelationship(item.get("relationship").toString());
				 record.setWorkCompany(item.get("workCompany").toString());
				 //fList.add(record);
				 familyMemberMapper.insert(record);
			}
		}
		
		//培训经历
		String train=params.get("train").toString();
		JSONArray trainList = JSONArray.parseArray(train);
//		List<PersonTrain> tList=new ArrayList<>();
		if(trainList.size()>0){
			for (int i = 0; i < trainList.size(); i++) {
				PersonTrain record=new PersonTrain();
				 JSONObject item = trainList.getJSONObject(i);
				 record.setPersonId(uuid);
				 record.setCertificate(item.get("certificate").toString());
				 record.setCompany(item.get("company").toString());
				 record.setTimeSlot(item.get("timeSlot").toString());
				 record.setTrainName(item.get("trainName").toString());
//				 tList.add(record);
				 personTrainMapper.insert(record);
			}
		}
		//工作
		String workExperience=params.get("workExperience").toString();
		JSONArray workExperienceList = JSONArray.parseArray(workExperience);
		if(workExperienceList.size()>0){
			for (int i = 0; i < workExperienceList.size(); i++) {
				PersonWorkExperience record=new PersonWorkExperience();
				 JSONObject item = workExperienceList.getJSONObject(i);
				 record.setPersonId(uuid);
				 record.setTimeSlot(item.get("timeSlot").toString());
				 record.setConsultantName(item.get("consultantName").toString());//联系人姓名
				 record.setConsultantNum(item.get("consultantNum").toString());//联系人电话
				 record.setJob(item.get("job").toString());//职位
				 record.setPay(item.get("pay").toString());//待遇
				 record.setReasons(item.get("reasons").toString());//离职原因
				 record.setWorkCompany(item.get("workCompany").toString());//单位名称
//				 tList.add(record);
				 personWorkExperience.insert(record);
			}
		}
		
		//背景调查联系人
		String consultant=params.get("consultant").toString();
		JSONArray consultantList = JSONArray.parseArray(consultant);
//		List<PersonConsultant> cList=new ArrayList<>();
		if(consultantList.size()>0){
			for (int i = 0; i < consultantList.size(); i++) {
				PersonConsultant record=new PersonConsultant();
				 JSONObject item = consultantList.getJSONObject(i);
				 record.setPersonId(uuid);
				 record.setJob(item.get("job").toString());
				 record.setName(item.get("name").toString());
				 record.setPhoneNum(item.get("phoneNum").toString());
				 record.setWorkCompany(item.get("workCompany").toString());
//				 cList.add(record);
				 personConsultantMapper.insert(record);
			}
		}
		
		return uuid;
	}

	@Override
	public ResultPage getPaperPage(Map param) {
		ResultPage resultPage=new ResultPage();
		if(param.size()==0) {
			return null;
		}
		Integer page=Integer.parseInt(param.get("page").toString());
		Integer pageSize=Integer.parseInt(param.get("pageSize").toString());
		int count=0;//总数
		int maxPage=1;//最大页数
		List<PersonInfo> list=null;//数据
		
		//组合拼装sql
		StringBuilder sql=new StringBuilder("1=1");
		
		//获取查询条件的关键词
		String name=param.get("name").toString();
		String sex=param.get("sex").toString();
		String phoneNum=param.get("phoneNum").toString();
		String applyJob=param.get("applyJob").toString();
		if(!StringUtils.isEmpty(name)){
			 sql.append(" and name like '%"+name+"%'" );
		}
		if(!StringUtils.isEmpty(sex)){
			 sql.append(" and sex='"+sex+"'" );
		}
		if(!StringUtils.isEmpty(phoneNum)){
			 sql.append(" and phoneNum like '%"+phoneNum+"%'" );
		}
		if(!StringUtils.isEmpty(applyJob)){
			 sql.append(" and title apply_job '%"+applyJob+"%'" );
		}
		
		//查询总数
		count= personInfoMapper.selectCount(sql.toString());
		if(count>=0) {
			//生产排序和分页sql
			String pageSql=SqlUtil.page(page, pageSize, param);
			sql.append(pageSql);
			list=personInfoMapper.selectBySql(sql.toString());
			maxPage=(count%pageSize)==0? (count/pageSize):(count/pageSize)+1;
		}
		
		resultPage.setTotal(count);
		resultPage.setPage(page);
		resultPage.setPageSize(pageSize);
		resultPage.setData(list);
		resultPage.setMaxPage(maxPage);
		return resultPage;
	}


	@Override
	public Map<String,Object> getPersonInfoById(String personId) {
		String sql="1=1 and person_id='"+personId+"'";
		PersonInfo info= personInfoMapper.selectByPrimaryKey(personId);
		List<PersonEducation> PEList=personEducationMapper.selectBySql(sql);
		List<FamilyMember> FMList=familyMemberMapper.selectBySql(sql);
		List<PersonTrain> PTList=personTrainMapper.selectBySql(sql);
		List<PersonWorkExperience> PWEList=personWorkExperience.selectBySql(sql);
		List<PersonConsultant> PCList=personConsultantMapper.selectBySql(sql);
		Map<String,Object> map=new HashMap<>();
		map.put("form", info);
		map.put("education", PEList);
		map.put("family", FMList);
		map.put("train", PTList);
		map.put("workExperience", PWEList);
		map.put("consultant", PCList);
		
		return map;
	}

	}
