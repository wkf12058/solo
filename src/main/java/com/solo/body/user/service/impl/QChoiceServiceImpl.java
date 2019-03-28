package com.solo.body.user.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.solo.body.user.dao.QChoiceMapper;
import com.solo.body.user.model.QChoice;
import com.solo.body.user.service.IQChoiceService;
import com.solo.util.mybatis.ResultPage;
import com.solo.util.mybatis.SqlUtil;

@Service
@Transactional
public class QChoiceServiceImpl implements IQChoiceService{

	@Resource
	private QChoiceMapper choiceMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return choiceMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(QChoice record) {
		return choiceMapper.insert(record);
	}

	@Override
	public int insertSelective(QChoice record) {
		return choiceMapper.insertSelective(record);
	}

	@Override
	public QChoice selectByPrimaryKey(Integer id) {
		return choiceMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(QChoice record) {
		return choiceMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(QChoice record) {
		return choiceMapper.updateByPrimaryKey(record);
	}

	@Override
	public ResultPage getChoicePage(Map param) {
		ResultPage resultPage=new ResultPage();
		if(param.size()==0) {
			return null;
		}
		Integer page=Integer.parseInt(param.get("page").toString());
		Integer pageSize=Integer.parseInt(param.get("pageSize").toString());
		int count=0;//总数
		int maxPage=1;//最大页数
		List<QChoice> list=null;//数据
		
		//组合拼装sql
		StringBuilder sql=new StringBuilder("1=1");
		
		//获取查询条件的关键词
		String type=param.get("type").toString();
		String title=param.get("title").toString();
		if(!StringUtils.isEmpty(type)){
			 sql.append(" and type='"+type+"'" );
		}
		if(!StringUtils.isEmpty(title)){
			 sql.append(" and title like '%"+title+"%'" );
		}
		
		//查询总数
		count= choiceMapper.selectCount(sql.toString());
		if(count>=0) {
			//生产排序和分页sql
			String pageSql=SqlUtil.page(page, pageSize, param);
			sql.append(pageSql);
			list=choiceMapper.selectBySql(sql.toString());
			maxPage=(count%pageSize)==0? (count/pageSize):(count/pageSize)+1;
		}
		
		resultPage.setTotal(count);
		resultPage.setPage(page);
		resultPage.setPageSize(pageSize);
		resultPage.setData(list);
		resultPage.setMaxPage(maxPage);
		return resultPage;
	}

	
	@Override
	public List<QChoice> getMoreByIds(String ids) {
		String sql="id in ("+ids+")";
		return choiceMapper.selectBySql(sql.toString());
	}

	
}
