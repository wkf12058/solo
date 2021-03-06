package com.solo.body.user.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.solo.body.user.dao.QPaperMapper;
import com.solo.body.user.model.QChoice;
import com.solo.body.user.model.QPaper;
import com.solo.body.user.service.IQPaperService;
import com.solo.util.mybatis.ResultPage;
import com.solo.util.mybatis.SqlUtil;

@Service
@Transactional
public class QPaperServiceImpl implements IQPaperService{

	@Resource
	private QPaperMapper paperMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return paperMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(QPaper record) {
		return paperMapper.insert(record);
	}

	@Override
	public int insertSelective(QPaper record) {
		return paperMapper.insertSelective(record);
	}

	@Override
	public QPaper selectByPrimaryKey(Integer id) {
		return paperMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(QPaper record) {
		return paperMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(QPaper record) {
		return paperMapper.updateByPrimaryKey(record);
	}

	@Override
	public ResultPage getPaperPage(Map param) {
		ResultPage resultPage=new ResultPage();
		if(param.size()==0) {
			return null;
		}
		Integer page=Integer.parseInt(param.get("page").toString());
		Integer pageSize=Integer.parseInt(param.get("pageSize").toString());
		int count=0;//总数
		int maxPage=1;//最大页数
		List<QPaper> list=null;//数据
		
		//组合拼装sql
		StringBuilder sql=new StringBuilder("1=1");
		
		//获取查询条件的关键词
		String text=param.get("text").toString();
		String title=param.get("title").toString();
		if(!StringUtils.isEmpty(text)){
			 sql.append(" and title like '%"+text+"%'" );
		}
		if(!StringUtils.isEmpty(title)){
			 sql.append(" and title like '%"+title+"%'" );
		}
		
		//查询总数
		count= paperMapper.selectCount(sql.toString());
		if(count>=0) {
			//生产排序和分页sql
			String pageSql=SqlUtil.page(page, pageSize, param);
			sql.append(pageSql);
			list=paperMapper.selectBySql(sql.toString());
			maxPage=(count%pageSize)==0? (count/pageSize):(count/pageSize)+1;
		}
		
		resultPage.setTotal(count);
		resultPage.setPage(page);
		resultPage.setPageSize(pageSize);
		resultPage.setData(list);
		resultPage.setMaxPage(maxPage);
		return resultPage;
	}

}
