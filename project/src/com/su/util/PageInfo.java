package com.su.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class PageInfo {
	List list=new ArrayList();//��ѯ���
	int recordSize=0;//�ܼ�¼��
	int currentPage=1;//��ǰҳ��
	int pageSize=5;//ÿҳ��¼��
	String url=null;
	
	/**
	 * �����ҳ��
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
