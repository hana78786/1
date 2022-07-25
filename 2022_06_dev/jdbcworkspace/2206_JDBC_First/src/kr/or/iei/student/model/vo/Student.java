package kr.or.iei.student.model.vo;

import java.sql.Date;

public class Student {
	private String studentId;
	private String studentPwd;
	private String StudentName;
	private char gender;
	private int age;
	private String phone;
	private String address;
	private String hobby;
	private Date enrollDAte;
	private String email;
	


	public Student(String studentId, String sutdetPwd, String studentName, char gender, int age, String phone,
			String adress, String hobby, Date enrollDAte) {
		super();
		this.studentId = studentId;
		this.studentPwd = sutdetPwd;
		StudentName = studentName;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.address = address;
		this.hobby = hobby;
		this.enrollDAte = enrollDAte;
		this.email=email;
	}

	public Student() {
		
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentPwd() {
		return studentPwd;
	}

	public void setStudentPwd(String studentPwd) {
		this.studentPwd = studentPwd;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
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

	public Date getEnrollDAte() {
		return enrollDAte;
	}

	public void setEnrollDAte(Date enrollDAte) {
		this.enrollDAte = enrollDAte;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentPwd=" + studentPwd + ", StudentName=" + StudentName
				+ ", gender=" + gender + ", age=" + age + ", email="+email+", phone=" + phone + ", address=" + address + ", hobby="
				+ hobby + ", enrollDAte=" + enrollDAte + "]";
	}

	
	
	
}
