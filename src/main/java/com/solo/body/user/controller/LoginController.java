package com.solo.body.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.jms.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.solo.body.user.model.User;
import com.solo.body.user.service.IUserService;
import com.solo.util.contstant.ResultContant;
import com.solo.util.msg.ResultMsg;

/**
 * 用户登录注册
 * wkf
 * 2017-11-29
 */
@Controller()
@RequestMapping("/login")
public class LoginController {

	@Resource 
	private IUserService userService;
	
	
	/**
	 * 登录
	 * @param userId
	 * @param passWrod
	 * @param request
	 * @return
	 */
    @RequestMapping(value="/signIn")
    @ResponseBody
    public ResultMsg login(String userId,String passWord,HttpServletRequest request){  
    	ResultMsg resultMsg=new ResultMsg();
    	try {
	    	if(userId==null||passWord==null){
				resultMsg.error(ResultContant.RESULT_MSG_FAIL_NO_PARA,ResultContant.RESULT_CODE_FAIL_NO_PARA);
				return resultMsg;
	    	}
	    	User user=userService.selectByUserId(userId);
	    	if(user==null){
	    		resultMsg.error(ResultContant.RESULT_MSG_USERNAME_ERROR,ResultContant.RESULT_MSG_USERNAME_ERROR );
	    		return resultMsg;
	    	}
			if(!user.getPassword().equals(passWord)){
				resultMsg.error(ResultContant.RESULT_MSG_PASSWORD_ERROR,ResultContant.RESULT_CODE_PASSWORD_ERROR );
				return resultMsg;
			}
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);
			resultMsg.success(null);
		} catch (Exception e) {
			e.printStackTrace();
			resultMsg.error(ResultContant.RESULT_MSG_FAIL,ResultContant.RESULT_CODE_FAIL );
			return resultMsg;
		}
        return resultMsg;
    }
    
    /**
     * 注册
     * @param userId
     * @param passWrod
     * @return
     */
    @RequestMapping(value="/register")
    @ResponseBody
    public ResultMsg register(String userId,String passWord){
    	ResultMsg resultMsg=new ResultMsg();
    	try {
	    	if(userId==null||passWord==null){
				resultMsg.error(ResultContant.RESULT_MSG_FAIL_NO_PARA,ResultContant.RESULT_CODE_FAIL_NO_PARA);
	    		return resultMsg;
	    	}
	    	User user=new User();
	    	user.setUserid(userId);
	    	user.setPassword(passWord);
	    	user.setUsername(userId);
	    	userService.insert(user);
			resultMsg.success(null);
		} catch (Exception e) {
			e.printStackTrace();
			resultMsg.error(ResultContant.RESULT_MSG_FAIL,ResultContant.RESULT_CODE_FAIL );
			return resultMsg;
		}
    	 return resultMsg;
    }
     
    /**
     * 确认账号重复
     * @param userId
     * @return
     */
    @RequestMapping(value="/userIdRepeat")
    @ResponseBody
    public ResultMsg userIdRepeat(String userId){
    	ResultMsg resultMsg=new ResultMsg();
    	try {
	    	User user= userService.selectByUserId(userId);
	    	if(user!=null){
	    		resultMsg.error(ResultContant.RESULT_MSG_USERNAME_REPEAT,ResultContant.RESULT_CODE_USERNAME_REPEAT );
	    		return resultMsg;
	    	}
	    	resultMsg.success(null);
		} catch (Exception e) {
			e.printStackTrace();
			resultMsg.error(ResultContant.RESULT_MSG_FAIL,ResultContant.RESULT_CODE_FAIL );
			return resultMsg;
		}
    	 return resultMsg;
    }
    
    /**
     * 修改密码
     * @param userId
     * @param passWrod
     * @return
     */
    @RequestMapping(value="/alterPassWord")
    @ResponseBody
    public ResultMsg alterPassWord(String userId,String passWrod){
    	ResultMsg resultMsg=new ResultMsg();
    	User findUser=new User();
    	findUser.setUserid(userId);
    	int Result=userService.updateByPrimaryKey(findUser);
    	if(Result>0){
    		
    	}
    	
		resultMsg.success(null);
    	 return resultMsg;
    }
    
    
    @RequestMapping(value = "/test")
    @ResponseBody
    public ResultMsg test(){  
    	ResultMsg resultMsg=new ResultMsg();
        
        return resultMsg;
    }
    
}
