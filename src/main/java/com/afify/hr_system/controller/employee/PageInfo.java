package com.afify.hr_system.controller.employee;

public class PageInfo {
	private int pageNum;
	private int pageSize;
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public PageInfo(int pageNum, int pageSize) {
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;
	}
	public PageInfo() {
		super();
	}
	
}
