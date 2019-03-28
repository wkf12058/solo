package com.solo.body.user.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.solo.util.basics.controller.BaseController;
import com.solo.util.basics.msg.ResultMsg;

@Controller()
@RequestMapping("/system")
public class SystemController extends BaseController{

	/**
	 * 添加信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/addPersonInfo")
	@ResponseBody
	public ResultMsg addPersonInfo(HttpServletRequest request) {
		ResultMsg resultMsg = new ResultMsg();
		Map  param=getParameterMap(request);
		resultMsg.success(null);
		return resultMsg;
	}
	
	/**
	 * 获取用户信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getPersonInfo")
	@ResponseBody
	public ResultMsg getPersonInfo(HttpServletRequest request) {
		ResultMsg resultMsg = new ResultMsg();
		Map  param=getParameterMap(request);
		resultMsg.success(null);
		return resultMsg;
	}
}
