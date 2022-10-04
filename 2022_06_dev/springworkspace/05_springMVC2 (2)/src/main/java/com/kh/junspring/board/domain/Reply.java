package com.kh.junspring.board.domain;

import java.sql.Date;

public class Reply {
	private int replyNo;
	private int refBoardNo;
	private String replyContents;
	private String replyWirter;
	private Date rCreateDate;
	private Date rUpdateDate;
	private String rStatus;
	
	
	public String getrStatus() {
		return rStatus;
	}


	public void setrStatus(String rStatus) {
		this.rStatus = rStatus;
	}


	public Reply() {
		
	}
	
	
	public Reply(int replyNo, int refBoardNo, String replyContents, String replyWirter, Date rCreateDate,
			Date rUpdateDate) {
		super();
		this.replyNo = replyNo;
		this.refBoardNo = refBoardNo;
		this.replyContents = replyContents;
		this.replyWirter = replyWirter;
		this.rCreateDate = rCreateDate;
		this.rUpdateDate = rUpdateDate;
	}
	@Override
	public String toString() {
		return "Reply [replyNo=" + replyNo + ", refBoardNo=" + refBoardNo + ", replyContents=" + replyContents
				+ ", replyWirter=" + replyWirter + ", rCreateDate=" + rCreateDate + ", rUpdateDate=" + rUpdateDate
				+ "]";
	}
	public int getReplyNo() {
		return replyNo;
	}
	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}
	public int getRefBoardNo() {
		return refBoardNo;
	}
	public void setRefBoardNo(int refBoardNo) {
		this.refBoardNo = refBoardNo;
	}
	public String getReplyContents() {
		return replyContents;
	}
	public void setReplyContents(String replyContents) {
		this.replyContents = replyContents;
	}
	public String getReplyWirter() {
		return replyWirter;
	}
	public void setReplyWirter(String replyWirter) {
		this.replyWirter = replyWirter;
	}
	public Date getrCreateDate() {
		return rCreateDate;
	}
	public void setrCreateDate(Date rCreateDate) {
		this.rCreateDate = rCreateDate;
	}
	public Date getrUpdateDate() {
		return rUpdateDate;
	}
	public void setrUpdateDate(Date rUpdateDate) {
		this.rUpdateDate = rUpdateDate;
	}
	
	

}
