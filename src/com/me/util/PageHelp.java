package com.me.util;
import com.me.domain.User;

import java.util.List;

public class PageHelp<T> {

	private int currentPage;	//	当前页  currentPage

	private int pageSize ;	//	页面大小 pageSize

	private int totalCount;	//	总数据 totalCount

	private int totalPage ;	//	总页数   totalPage

	private List<T> list;	//	当前页的数据集合  list
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	/*
	 * 总页数 = 数据总数%页面大小==0? 数据总数/页面大小:数据总数/页面大小+1 ;
	 * 
	 * 当我们调用了 数据总数的set() 和 页面大小的set()以后，自动计算出 总页数 totalPage
	 * 务必注意顺序：先set 数据总数   再set 页面大小
	 */
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		//自动计算出 总页数		
        //总页数 = 数据总数%页面大小==0? 数据总数/页面大小:数据总数/页面大小+1 ;
		this.totalPage =this.totalCount%this.pageSize==0?this.totalCount/this.pageSize:totalCount/this.pageSize+1; 
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	//给总页数赋值
/*	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}*/
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
}
