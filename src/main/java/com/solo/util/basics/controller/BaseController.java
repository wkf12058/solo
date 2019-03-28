package com.solo.util.basics.controller;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
public class BaseController {

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
	
	  /** 
     * 从request中获得参数Map，并返回可读的Map 
     *  
     * @param request 
     * @return 
     */  
    @SuppressWarnings({ "unchecked", "rawtypes" })  
    public static Map getParameterMap(HttpServletRequest request) {  
        // 参数Map  
        Map properties = request.getParameterMap();  
        // 返回值Map  
        Map returnMap = new HashMap();  
        Iterator entries = properties.entrySet().iterator();  
        Map.Entry entry;  
        String name = "";  
        String value = "";  
        while (entries.hasNext()) {  
            entry = (Map.Entry) entries.next();  
            name = (String) entry.getKey();  
            Object valueObj = entry.getValue();  
            if(null == valueObj){  
                value = "";  
            }else if(valueObj instanceof String[]){  
                String[] values = (String[])valueObj;  
                for(int i=0;i<values.length;i++){  
                    value = values[i] + ",";  
                }  
                value = value.substring(0, value.length()-1);  
            }else{  
                value = valueObj.toString();  
            }  
            returnMap.put(name, value);  
        }  
        return returnMap;  
    } 
}
