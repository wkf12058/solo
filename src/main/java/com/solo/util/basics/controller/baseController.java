package com.solo.util.basics.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.solo.util.basics.defense.DefenseXss;



/**
 * Controller 的基础类 所有Controller都必须基础此类
 * 作用：在sping MVC拦截到到请求进入Controller层之前。做一些预处理
 * wkf
 * 2018-2-8
 */
@Controller
@RequestMapping("/baseController")
public class baseController {

	/**
	 * 初始化的时候执行一些操作
	 * wkf
	 * 2018-2-8
	 *@param binder
	 */
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder){
		//防止XSS攻击
//		binder.registerCustomEditor(String.class, new DefenseXss(true, false));
		
	}
	
	
}
