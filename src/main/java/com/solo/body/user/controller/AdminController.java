package com.solo.body.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.solo.body.user.model.PersonAnswer;
import com.solo.body.user.model.QChoice;
import com.solo.body.user.model.QPaper;
import com.solo.body.user.service.IFamilyMemberService;
import com.solo.body.user.service.IPersonAnswerService;
import com.solo.body.user.service.IPersonConsultantService;
import com.solo.body.user.service.IPersonEducationService;
import com.solo.body.user.service.IPersonInfoService;
import com.solo.body.user.service.IPersonTrainService;
import com.solo.body.user.service.IQChoiceService;
import com.solo.body.user.service.IQPaperService;
import com.solo.util.basics.controller.BaseController;
import com.solo.util.basics.msg.ResultMsg;
import com.solo.util.mybatis.ResultPage;

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
	
	
	
}
