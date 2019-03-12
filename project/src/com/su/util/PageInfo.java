package com.su.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class PageInfo {
	List list=new ArrayList();//查询结果
	int recordSize=0;//总记录数
	int currentPage=1;//当前页数
	int pageSize=5;//每页记录数
	String url=null;
	
	/**
	 * 获得总页数
	 * @return
	 */
	public int getPageCount() {
		return this.recordSize%this.pageSize==0?this.recordSize/this.pageSize:this.recordSize/this.pageSize+1;
	}
	
	@Override
	public String toString() {
		return "PageInfo [list=" + list + ", recordSize=" + recordSize + ", currentPage=" + currentPage + ", pageSize="
				+ pageSize + ", url=" + url + "]";
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public int getRecordSize() {
		return recordSize;
	}

	public void setRecordSize(int recordSize) {
		this.recordSize = recordSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public PageInfo(HttpServletRequest requst) {
		if(requst.getParameter("currentPage")!=null && !"".equals(requst.getParameter("currentPage"))) {
			this.currentPage=Integer.valueOf(requst.getParameter("currentPage"));
		}
		url=requst.getRequestURL().toString();
		requst.setAttribute("pageInfo", this);
	}

}
