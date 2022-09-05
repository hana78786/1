package com.kh.junspring.member.domain;

import java.sql.Date;

import org.springframework.web.bind.annotation.RequestParam;

public class Member {

	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberEmail;
	private String memberPhone;
	private String memberAddress;
	private Date endrollDate;
	private Date updateDate;
	private String status;
	
 

	public Member(String memberId, String memberPw, String memberName, String memberEmail, String memberPhone, String memberAddress) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberEmail = memberEmail;
		this.memberPhone = memberPhone;
		this.memberAddress = memberAddress;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public Date getEndrollDate() {
		return endrollDate;
	}

	public void setEndrollDate(Date endrollDate) {
		this.endrollDate = endrollDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberPw=" + memberPw + ", memberName=" + memberName
				+ ", memberEmail=" + memberEmail + ", memberPhone=" + memberPhone + ", memberAddress=" + memberAddress
				+ "]";
	}
	
	
	
	
}
