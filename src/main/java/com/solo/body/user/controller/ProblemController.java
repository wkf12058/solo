package com.solo.body.user.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.jdbc.StringUtils;
import com.solo.body.user.dto.ProbleParam;
import com.solo.body.user.model.Problem;
import com.solo.body.user.model.SoUser;
import com.solo.body.user.model.User;
import com.solo.body.user.model.UserAnswer;
import com.solo.body.user.service.IProblemService;
import com.solo.body.user.service.ISoUserService;
import com.solo.body.user.service.IUserAnsweService;
import com.solo.body.user.service.IUserService;
import com.solo.util.basics.msg.ResultMsg;
import com.solo.util.wx.WxUtil;

import sun.print.resources.serviceui;

/**
 * 
 * wkf
 * 2017-11-29
 */
@Controller()
@RequestMapping("/problem")
public class ProblemController {

	@Resource 
	private IProblemService problemService;
	
	@Resource 
	private ISoUserService soUserService;
	
	@Resource 
	private IUserAnsweService userAnsweService;
	
	/**
	 * 获取题目信息
	 * @param sgin
	 * @return
	 */
    @RequestMapping("/getList")
    @ResponseBody
    public ResultMsg getProblemList(String userId,String sign){
    	ResultMsg resultMsg=new ResultMsg();
    	Map<String, Object> param=new HashMap<>();
    	param.put("sign", sign);
    	param.put("userId", userId);
    	
    	String sql=" user_id='"+userId+"'and sign='"+sign+"' ";
    	List<UserAnswer> ualist=userAnsweService.selectBySql(sql);
    	if(ualist.size()>0) {
    		
    		resultMsg.success("END");
    		return resultMsg;
    	}
    	List<Problem> list=problemService.selectBySgin(param);
    	List<Map<String, Object>> resultList=new ArrayList<>();
    	for (int i = 0; i < list.size(); i++) {
    		Map<String, Object> map=new HashMap<>();
    		Problem pro=list.get(i);
    		map.put("id", pro.getId());
    		map.put("title", pro.getTitle());
    		map.put("answer", pro.getAnswer());
    		String[] xuanxiang= {pro.getOption1(),pro.getOption2(),pro.getOption3(),pro.getOption4()};
    		map.put("xuanxiang", xuanxiang);
    		resultList.add(map);
		}
    	resultMsg.success(resultList);
    	return resultMsg;
    }
    
    
    /**
     * 注册填写信息
     * @param request
     * @param param
     * @return
     */
    @RequestMapping("/register")
    @ResponseBody
    public ResultMsg register(HttpServletRequest request,ProbleParam param){
    	ResultMsg resultMsg=new ResultMsg();
    	SoUser user=new SoUser();
    	user.setUserName(param.name);
    	user.setPhone(param.phone);
    	if(!StringUtils.isNullOrEmpty(param.openId)) {
    		user.setOpenId(param.openId);
    	}
    	user.setAddress(param.address);
    	if(soUserService.insertSelective(user)>0) {
    		List<SoUser> userList=soUserService.getUserByOpenId(param.openId);
    		resultMsg.success(userList.get(0).getId());
    	}
    	return resultMsg;
    }
    
    /**
     * 微信登录
     * @param request
     * @param param
     * @return
     */
    @RequestMapping("/wxlogin")
    @ResponseBody
    public ResultMsg wxlogin(HttpServletRequest request,String code){
    	ResultMsg resultMsg=new ResultMsg();
    	
    	String openId="";
    	openId=WxUtil.openId(code).get("openId").toString();
    	List<SoUser> userList=soUserService.getUserByOpenId(openId);
    	if(userList.size()>0) {
    		SoUser user=userList.get(0);
    		if(user!=null) {
        		Map<String, String> map=new HashMap<>();
        		map.put("type", "1");
        		map.put("userId",user.getId().toString());
    			resultMsg.success(map);
    		}
    	}else {
    		Map<String, String> map=new HashMap<>();
    		map.put("type", "2");
    		map.put("openId", openId);
    		resultMsg.success(map);
    	}
    	return resultMsg;
    }
    
    /**
     * 用户提交答案
     * @param request
     * @param param
     * @return
     */
    @RequestMapping("/submitAssets")
    @ResponseBody
    public ResultMsg submitAssets(HttpServletRequest request,ProbleParam param){//HttpServletRequest request,
    	ResultMsg resultMsg=new ResultMsg();
    	UserAnswer record=new UserAnswer();
    	record.setUserId(Integer.parseInt(param.userId));
    	record.setAnswer(param.answer.toString());
    	record.setProblemId(param.problemId.toString());
    	record.setScore(param.score);
    	record.setSign(param.sign);
    	if(userAnsweService.insert(record)>0) {
    		resultMsg.success("成功");
    	}
    	return resultMsg;
    }
    
    /**
     * 获取答题情况
     * @param userId
     * @return
     */
    @RequestMapping("/getAnswerByUserId")
    @ResponseBody
    public ResultMsg getAnswerByUserId(String userId){
    	ResultMsg resultMsg=new ResultMsg();
    	String sql=" user_id='"+userId+"' " ;
    	List<UserAnswer> list=userAnsweService.selectBySql(sql);
    	resultMsg.success(list);
    	return resultMsg;
    }
    
}
