package com.kh.notice.model.vo;

import java.sql.Date;

public class Notice {
	
	
	private String subject;
	private String contents;
	private String memberId;
	private int noticeNo;
	private Date regDate;
	
	//생성자 게터세터 toString
	
	public Notice() {
		
	}

	public Notice(String subject, String contents, String memberId, int noticeNo, Date regDate) {
		super();
		this.subject = subject;
		this.contents = contents;
		this.memberId = memberId;
		this.noticeNo = noticeNo;
		this.regDate = regDate;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Notice [subject=" + subject + ", contents=" + contents + ", memberId=" + memberId + ", noticeNo="
				+ noticeNo + ", regDate=" + regDate + "]";
	}
	
	

}
