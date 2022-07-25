package Student;

import java.util.Date;

public class Student {
	private String student_id;
	private String student_pwd;
	private String student_name;
	private char gender;
	private int age;
	private String email;
	private String phone;
	private String address;
	private String hobby;
	private Date enroll_date;

	public Student() {
		
	}

	public Student(String student_id, String student_pwd, String student_name, char gender, int age, String email,
			String phone, String address, String hobby, Date enroll_date) {
		super();
		this.student_id = student_id;
		this.student_pwd = student_pwd;
		this.student_name = student_name;
		this.gender = gender;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.hobby = hobby;
		this.enroll_date = enroll_date;
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getStudent_pwd() {
		return student_pwd;
	}

	public void setStudent_pwd(String student_pwd) {
		this.student_pwd = student_pwd;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
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

	public Date getEnroll_date() {
		return enroll_date;
	}

	public void setEnroll_date(Date enroll_date) {
		this.enroll_date = enroll_date;
	}

	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", student_pwd=" + student_pwd + ", student_name=" + student_name
				+ ", gender=" + gender + ", age=" + age + ", email=" + email + ", phone=" + phone + ", address="
				+ address + ", hobby=" + hobby + ", enroll_date=" + enroll_date + "]";
	}
	
	
	
}
