package com.kh.exproject.domain;

import java.sql.Date;

public class Member {
	
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberEmail;
	private String memberPhone;
	private String address;
	private Date endrollDate;
	private Date updateDate;
	private String mStatus;

	
	public Member() {
		
	}


	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberPw=" + memberPw + ", memberName=" + memberName
				+ ", memberEmail=" + memberEmail + ", memberPhone=" + memberPhone + ", address=" + address
				+ ", endrollDate=" + endrollDate + ", updateDate=" + updateDate + ", mStatus=" + mStatus + "]";
	}


	public Member(String memberId, String memberPw, String memberName, String memberEmail, String memberPhone,
			String address, Date endrollDate, Date updateDate, String mStatus) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberEmail = memberEmail;
		this.memberPhone = memberPhone;
		this.address = address;
		this.endrollDate = endrollDate;
		this.updateDate = updateDate;
		this.mStatus = mStatus;
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


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
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


	public String getmStatus() {
		return mStatus;
	}


	public void setmStatus(String mStatus) {
		this.mStatus = mStatus;
	}
	
	
		
	
}


