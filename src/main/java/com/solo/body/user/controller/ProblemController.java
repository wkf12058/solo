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

import com.solo.body.user.model.Problem;
import com.solo.body.user.model.User;
import com.solo.body.user.service.IProblemService;
import com.solo.body.user.service.IUserService;
import com.solo.util.basics.msg.ResultMsg;

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
	
	
    @RequestMapping("/getList")
    @ResponseBody
    public ResultMsg getProblemList(String sgin){
    	ResultMsg resultMsg=new ResultMsg();
    	Map<String, Object> param=new HashMap<>();
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
    
    
    
}
