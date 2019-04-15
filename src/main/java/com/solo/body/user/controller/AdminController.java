package com.solo.body.user.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.solo.body.user.dao.MainShowMapper;
import com.solo.body.user.dao.PersonBsicsMapper;
import com.solo.body.user.model.MainShow;
import com.solo.body.user.model.PersonAnswer;
import com.solo.body.user.model.PersonBsics;
import com.solo.body.user.model.PersonEducation;
import com.solo.body.user.model.PersonOtherAnswer;
import com.solo.body.user.model.QChoice;
import com.solo.body.user.model.QPaper;
import com.solo.body.user.service.IFamilyMemberService;
import com.solo.body.user.service.IPersonAnswerService;
import com.solo.body.user.service.IPersonConsultantService;
import com.solo.body.user.service.IPersonEducationService;
import com.solo.body.user.service.IPersonInfoService;
import com.solo.body.user.service.IPersonOtherAnswerService;
import com.solo.body.user.service.IPersonTrainService;
import com.solo.body.user.service.IQChoiceService;
import com.solo.body.user.service.IQPaperService;
import com.solo.util.basics.controller.BaseController;
import com.solo.util.basics.msg.ResultMsg;
import com.solo.util.mybatis.ResultPage;
import com.solo.util.mybatis.SqlUtil;

@Controller()
@RequestMapping("/admin")
public class AdminController  extends BaseController{

	
	@Resource
	private IQChoiceService choiceService;
	@Resource
	private IQPaperService paperService;
	
	@Resource
	private IPersonInfoService personInfoService;//个人信息
	
	@Resource
	private IPersonAnswerService personAnswerService;//个人答案
	
	@Resource
	private IPersonOtherAnswerService personOtherAnswerService;//其他答案

	//后面有时间分层处理一下
	@Resource
	private  MainShowMapper mainShowMapper;//主页面
	
	@Resource
	private PersonBsicsMapper personBsicsMapper;//基础信息
	
	/////////////////////////////////////////////////////////获取
	
	/**获取试题分页
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getPaperPage")
	@ResponseBody
	public ResultMsg getPaperPage(HttpServletRequest request) {
		ResultMsg resultMsg = new ResultMsg();
		Map  param=getParameterMap(request);
		ResultPage resultPage= paperService.getPaperPage(param);
		resultMsg.success(resultPage);
		return resultMsg;
	}
	
	/**获取人员分页
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getPersonPage")
	@ResponseBody
	public ResultMsg getPersonPage(HttpServletRequest request) {
		ResultMsg resultMsg = new ResultMsg();
		Map  param=getParameterMap(request);
		ResultPage resultPage= personInfoService.getPaperPage(param);
		resultMsg.success(resultPage);
		return resultMsg;
	}
	
	/**根据id获取人员
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getPersonInfoById")
	@ResponseBody
	public ResultMsg getPersonInfoById(HttpServletRequest request,String personId) {
		ResultMsg resultMsg = new ResultMsg();
		Map resultMap= personInfoService.getPersonInfoById(personId);
		resultMsg.success(resultMap);
		return resultMsg;
	}
	
	
	
	/**根据id获取试题
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getPaperById")
	@ResponseBody
	public ResultMsg getPaperById(HttpServletRequest request) {
		ResultMsg resultMsg = new ResultMsg();
		Map<String,String>  param=getParameterMap(request);
		Integer id=Integer.parseInt(param.get("id"));
		QPaper paper= paperService.selectByPrimaryKey(id);
		if(paper==null) {
			resultMsg.error();
			return resultMsg;
		}
		List<QChoice> list=choiceService.getMoreByIds(paper.getQuestionId());
		Map<String, Object> resultMap=new HashMap<>();
		resultMap.put("list", list);
		resultMap.put("paper", paper);
		resultMsg.success(resultMap);
		return resultMsg;
	}
	
	/**
	 * 获取题目
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getChoicePage")
	@ResponseBody
	public ResultMsg getChoiceList(HttpServletRequest request) {
		ResultMsg resultMsg = new ResultMsg();
		Map  param=getParameterMap(request);
		ResultPage resultPage= choiceService.getChoicePage(param);
		resultMsg.success(resultPage);
		return resultMsg;
	}
	
	/**
	 * 获取答案 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getPersonAnwser")
	@ResponseBody
	public ResultMsg getPersonAnwser(HttpServletRequest request) {
		ResultMsg resultMsg = new ResultMsg();
		Map  param=getParameterMap(request);
		PersonAnswer result= personAnswerService.getPersonAnwser(param);
		resultMsg.success(result);
		return resultMsg;
	}
	
	/**
	 * 获取问答题答案 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getQuestionsAnswer")
	@ResponseBody
	public ResultMsg getQuestionsAnswer(HttpServletRequest request,String personId) {
		ResultMsg resultMsg = new ResultMsg();
		List<PersonOtherAnswer> result= personOtherAnswerService.getByPersonId(personId);
		resultMsg.success(result);
		return resultMsg;
	}
	
	
	/** 获取主页面显示
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getMain")
	@ResponseBody
	public ResultMsg getMain(HttpServletRequest request) {
		ResultMsg resultMsg = new ResultMsg();
		List<MainShow> result= mainShowMapper.selectBySql("1=1 order by sort asc");
		resultMsg.success(result);
		return resultMsg;
	}
	
	/** 获取主页面显示
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getBriefPage")
	@ResponseBody
	public ResultMsg getBriefPage(HttpServletRequest request) {
		ResultMsg resultMsg = new ResultMsg();
		Map  param=getParameterMap(request);
		ResultPage resultPage=new ResultPage();
		if(param.size()==0) {
			return null;
		}
		Integer page=Integer.parseInt(param.get("page").toString());
		Integer pageSize=Integer.parseInt(param.get("pageSize").toString());
		int count=0;//总数
		int maxPage=1;//最大页数
		List<PersonBsics> list=null;//数据
		
		//组合拼装sql
		StringBuilder sql=new StringBuilder("1=1");
		
		//获取查询条件的关键词
		String name=param.get("name").toString();
		String sex=param.get("sex").toString();
		String phone=param.get("phone").toString();
		String school=param.get("school").toString();
		String major=param.get("major").toString();
		String internshipTime=param.get("internshipTime").toString();
		if(!StringUtils.isEmpty(sex)){
			 sql.append(" and sex='"+sex+"'" );
		}
		if(!StringUtils.isEmpty(name)){
			 sql.append(" and title name '%"+name+"%'" );
		}
		if(!StringUtils.isEmpty(phone)){
			 sql.append(" and phone='"+phone+"'" );
		}
		if(!StringUtils.isEmpty(school)){
			 sql.append(" and school like '%"+school+"%'" );
		}
		if(!StringUtils.isEmpty(major)){
			 sql.append(" and major like '%"+major+"%'" );
		}
		//查询总数
		count= personBsicsMapper.selectCount(sql.toString());
		if(count>=0) {
			//生产排序和分页sql
			String pageSql=SqlUtil.page(page, pageSize, param);
			sql.append(pageSql);
			list=personBsicsMapper.selectBySql(sql.toString());
			maxPage=(count%pageSize)==0? (count/pageSize):(count/pageSize)+1;
		}
		
		resultPage.setTotal(count);
		resultPage.setPage(page);
		resultPage.setPageSize(pageSize);
		resultPage.setData(list);
		resultPage.setMaxPage(maxPage);
		
		resultMsg.success(resultPage);
		return resultMsg;
	}
	/////////////////////////////////////////////////////////添加
	
	/**
	 * 添加试卷
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/addPaper")
	@ResponseBody
	public ResultMsg addPaper(HttpServletRequest request) {
		ResultMsg resultMsg = new ResultMsg();
		Map  param=getParameterMap(request);
		QPaper record=new QPaper();
		record.setQuestionId(param.get("idList").toString());
		record.setText(param.get("text").toString());
		record.setTitle(param.get("title").toString());
		int result=paperService.insert(record);
		if(result>0) {	
			resultMsg.success();
		}else {
			resultMsg.error();
		}
		return resultMsg;
	}

	/**
	 * 添加试题
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/addChoice")
	@ResponseBody
	public ResultMsg addChoice(HttpServletRequest request) {
		ResultMsg resultMsg = new ResultMsg();
		Map  param=getParameterMap(request);
		QChoice record=new QChoice();
		record.setAnswer(param.get("anwser").toString());
		record.setTitle(param.get("title").toString());
		 String optios=param.get("options").toString();
		record.setOptions(optios.toString());
		record.setType(param.get("type").toString());
		int result= choiceService.insert(record);
		if(result>0) {	
			resultMsg.success();
		}else {
			resultMsg.error();
		}
		return resultMsg;
	}
	
	
	/**
	 * 填写信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/addPersonInfo")
	@ResponseBody
	public ResultMsg addPersonInfo(HttpServletRequest request) {
		ResultMsg resultMsg = new ResultMsg();
		Map  param=getParameterMap(request);
		String id= personInfoService.inputPersonAllInfo(param);
		resultMsg.success(id);
		return resultMsg;
	}
	
	/**
	 * 填写试卷
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/addPaperAnswer")
	@ResponseBody
	public ResultMsg addPaperAnswer(HttpServletRequest request) {
		ResultMsg resultMsg = new ResultMsg();
		Map<String,String>  param=getParameterMap(request);
		PersonAnswer answer=new PersonAnswer();
		answer.setPaperId(param.get("paperId"));
		answer.setPersonId(param.get("personId"));
		answer.setDics(param.get("dics"));
		answer.setAnswer(param.get("answer"));
		answer.setSign(param.get("sign"));
		int result =personAnswerService.insert(answer);
		if(result>0) {
			resultMsg.success();
		}else {
			resultMsg.error();
		}
		return resultMsg;
	}
	
	/**
	 * 填写问答题目
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/answerQuestions")
	@ResponseBody
	public ResultMsg AnswerQuestions(HttpServletRequest request) {
		ResultMsg resultMsg = new ResultMsg();
		Map<String,String>  param=getParameterMap(request);
		String personId=param.get("personId").toString();
		String json= param.get("list").toString();
		JSONArray list = JSONArray.parseArray(json);
		if(list.size()>0){
			for (int i = 0; i < list.size(); i++) {
				JSONObject item = list.getJSONObject(i);
				PersonOtherAnswer record=new PersonOtherAnswer();
				record.setPersonId(personId);
				record.setAnwser(item.get("anwser").toString());
				record.setTitle(item.get("title").toString());
				personOtherAnswerService.insert(record);
			}
		}
		resultMsg.success();
		return resultMsg;
	}
	
	/** 获取主页面显示
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/saveShow")
	@ResponseBody
	public ResultMsg saveShow(HttpServletRequest request) {
		ResultMsg resultMsg = new ResultMsg();
		Map<String,String>  param=getParameterMap(request);
		MainShow record=new MainShow();
		record.setShowId(param.get("showId"));
		record.setSort(param.get("sort"));
		record.setTag(param.get("tag"));
		record.setType(param.get("type"));
		record.setUpdateTime(new Date());
		int result=0;
		if(StringUtils.isEmpty(param.get("id"))) {
			result= mainShowMapper.insert(record);
		}else {
			record.setId(Integer.parseInt(param.get("id")));
			result= mainShowMapper.updateByPrimaryKeySelective(record);
		}
		if(result>0) {
			resultMsg.success();
		}
		return resultMsg;
	}
	
	/**
	 * 添加
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/addBsics")
	@ResponseBody
	public ResultMsg addBsics(HttpServletRequest request) {
		ResultMsg resultMsg = new ResultMsg();
		Map<String,String>  param=getParameterMap(request);
		PersonBsics record=new PersonBsics();
		record.setInputTime(new Date().toString());
		record.setInternshipTime(param.get("internshipTime"));
		record.setMajor(param.get("major"));
		record.setName(param.get("name"));
		record.setPhone(param.get("phone"));
		record.setSchool(param.get("school"));
		record.setSex(param.get("sex"));
		int result= personBsicsMapper.insert(record);
		if(result>0) {	
			resultMsg.success();
		}else {
			resultMsg.error();
		}
		return resultMsg;
	}
	
/////////////////////////////////////////////////////////删除
	
	/**
	 * 删除试卷
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/deletePaper")
	@ResponseBody
	public ResultMsg deletePaper(HttpServletRequest request) {
		ResultMsg resultMsg = new ResultMsg();
		Map<String,String>  param=getParameterMap(request);
		Integer id=Integer.parseInt(param.get("id"));
		int result=paperService.deleteByPrimaryKey(id);
		if(result>0) {	
			resultMsg.success();
		}else {
			resultMsg.error();
		}
		return resultMsg;
	}
	
	/**
	 * 删除题目
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/deleteChoice")
	@ResponseBody
	public ResultMsg deleteChoice(HttpServletRequest request) {
		ResultMsg resultMsg = new ResultMsg();
		Map<String,String>  param=getParameterMap(request);
		Integer id=Integer.parseInt(param.get("id"));
		int result= choiceService.deleteByPrimaryKey(id);
		if(result>0) {	
			resultMsg.success();
		}else {
			resultMsg.error();
		}
		return resultMsg;
	}
	
	/**
	 * 删除界面
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/deleteShow")
	@ResponseBody
	public ResultMsg deleteShow(HttpServletRequest request) {
		ResultMsg resultMsg = new ResultMsg();
		Map<String,String>  param=getParameterMap(request);
		Integer id=Integer.parseInt(param.get("id"));
		int result= mainShowMapper.deleteByPrimaryKey(id);
		if(result>0) {	
			resultMsg.success();
		}else {
			resultMsg.error();
		}
		return resultMsg;
	}
	
	

	
}
