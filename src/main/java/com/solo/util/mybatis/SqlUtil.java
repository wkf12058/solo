package com.solo.util.mybatis;

import java.util.Iterator;
import java.util.Map;

import org.springframework.util.StringUtils;

public class SqlUtil {
	
	/**
	 * 生成排序和分页语句
	 * @Title: page  
	 * @Description: TODO 
	 * @param page
	 * @param pageSize
	 * @param param
	 * @return 理想情况 : order by {sortWord} desc limit 1,10;
	 * @throws
	 * @author wkf
	 * @date 2019年2月26日 上午11:02:13
	 */
	public static String page(Integer page,Integer pageSize,Map param) {
		StringBuilder sql=new StringBuilder(" ");
		String sortWord=param.get("sortWord").toString(); 
		Integer isAsc=Integer.parseInt(param.get("isAsc").toString()); 
		//排序条件
		if(!StringUtils.isEmpty(sortWord)) {
			sql.append(" order by "+sortWord+(isAsc==1? " asc ":" desc "));
		}
		//分页条件
		String pageSql= " limit "+((page-1)*pageSize)+" , "+pageSize;
		sql.append(pageSql);
		return sql.toString();
	}
	
	/**
	 * 模板
	 * @Title: managePage  
	 * @Description: TODO 
	 * @param param
	 * @return 
	 * @throws
	 * @author wkf
	 * @date 2019年2月26日 上午10:47:05
	 */
	public static String managePage(Map param) {
		Integer page=Integer.parseInt(param.get("page").toString());
		Integer pageSize=Integer.parseInt(param.get("pageSize").toString());
		String sortWord=param.get("sortWord").toString(); 
		Integer isAsc=Integer.parseInt(param.get("isAsc").toString()); 
		param.remove("page");
		param.remove("pageSize");
		param.remove("sortWord");
		param.remove("isAsc");
		
		//组合拼装sql
		StringBuilder sql=new StringBuilder("1=1");
		
		//查询条件
		Iterator<Map.Entry> entries = param.entrySet().iterator(); 
		while (entries.hasNext()) { 
			//遍历map
		  Map.Entry<Integer, Integer> entry = entries.next(); 
		  if(!StringUtils.isEmpty(entry.getValue())) {
			  sql.append(" and "+entry.getKey()+" like '%"+entry.getValue()+"%' " );
			  System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue()); 
		  }
		}
		//排序条件
		if(!StringUtils.isEmpty(sortWord)) {
			sql.append(" order by "+sortWord+(isAsc==1? " asc ":" desc "));
		}
		//分页条件
		String pageSql= " limit "+((page-1)*pageSize)+" , "+pageSize;
		sql.append(pageSql);
		  	
		return sql.toString();
	}


}
