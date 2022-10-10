package test.test.test.domain;

public class Test {

	private String test;
	private String id;
	private String pass;

	
	public Test() {}
	public Test(String id, String pass) {
		super();
		this.id = id;
		this.pass = pass;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}
}
