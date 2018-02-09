package com.solo.body.user.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.solo.body.user.model.User;
import com.solo.body.user.service.IUserService;

/**
 * 
 * wkf
 * 2017-11-29
 */
@Controller()
@RequestMapping("/user")
public class UserController {

	@Resource 
	private IUserService userService;
	
	
    @RequestMapping("/showUser")
    @ResponseBody
    public String toIndex(HttpServletRequest request,Model model){  
        int userId = Integer.parseInt(request.getParameter("id"));  
        User user = this.userService.selectByPrimaryKey(1);  
        System.out.println(user.getUsername());
        model.addAttribute("user", user);  
        return "view/test";
    }
    
    
    
}
