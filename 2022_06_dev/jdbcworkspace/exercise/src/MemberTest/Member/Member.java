package MemberTest.Member;

import java.util.Date;

public class Member {
	public String MemberId;
	public String MemberName;
	public String MemberPwd;
	public char gender;
	public int age;
	public String email;
	public String phone;
	public String address;
	public String hobby;
	public Date endrollDate;
	
	public Member() {
		
	}
	
	
	public Member(String memberId, String memberName, String memberPwd, char gender, int age, String email,
			String phone, String address, String hobby, Date endrollDate) {
		super();
		MemberId = memberId;
		MemberName = memberName;
		MemberPwd = memberPwd;
		this.gender = gender;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.hobby = hobby;
		this.endrollDate = endrollDate;
	}


	public String getMemberId() {
		return MemberId;
	}


	public void setMemberId(String memberId) {
		MemberId = memberId;
	}


	public String getMemberName() {
		return MemberName;
	}


	public void setMemberName(String memberName) {
		MemberName = memberName;
	}


	public String getMemberPwd() {
		return MemberPwd;
	}


	public void setMemberPwd(String memberPwd) {
		MemberPwd = memberPwd;
	}


	public char getGender() {
		return gender;
	}


	public void setGender(char gender) {
		this.gender = gender;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getHobby() {
		return hobby;
	}


	public void setHobby(String hobby) {
		this.hobby = hobby;
	}


	public Date getEndrollDate() {
		return endrollDate;
	}


	public void setEndrollDate(Date endrollDate) {
		this.endrollDate = endrollDate;
	}


	@Override
	public String toString() {
		return "Member [MemberId=" + MemberId + ", MemberName=" + MemberName + ", MemberPwd=" + MemberPwd + ", gender="
				+ gender + ", age=" + age + ", email=" + email + ", phone=" + phone + ", address=" + address
				+ ", hobby=" + hobby + ", endrollDate=" + endrollDate + "]";
	}
	
	
	
}
