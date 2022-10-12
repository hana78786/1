package test.test.test.domain;

public class Test {
	private String mebmerId;
	private String memberPwd;
	
	public Test() {}

	public String getMebmerId() {
		return mebmerId;
	}

	public void setMebmerId(String mebmerId) {
		this.mebmerId = mebmerId;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public Test(String mebmerId, String memberPwd) {
		super();
		this.mebmerId = mebmerId;
		this.memberPwd = memberPwd;
	}
	
	

}
