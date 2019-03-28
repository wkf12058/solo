package com.solo.util.mybatis;

import java.util.List;

/**
 * service 查询返回的Page对象
 * @author wumin
 *
 */
public class ResultPage {
	/**总数量**/
	private int total;
	/**数据**/
	private List  data;
	/**分页大小**/
	private int  pageSize;
	/**当前页面**/
	private int  page;
	/**最大页数**/
	private int  maxPage;
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}

	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
	
}
