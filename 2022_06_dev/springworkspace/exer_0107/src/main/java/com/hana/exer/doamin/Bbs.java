package com.hana.exer.doamin;

import java.sql.Date;

public class Bbs {
	
	private int bbsNo;
	private String name;
	private String title;
	private Date date;
	private String contents;
	
	
	
	
	public int getBbsNo() {
		return bbsNo;
	}
	public void setBbsNo(int bbsNo) {
		this.bbsNo = bbsNo;
	}
	@Override
	public String toString() {
		return "Bbs [bbsNo=" + bbsNo + ", name=" + name + ", title=" + title + ", date=" + date + ", contents="
				+ contents + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	

}
