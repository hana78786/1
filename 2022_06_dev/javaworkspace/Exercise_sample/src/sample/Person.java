package sample;

public class Person { // 멤버 필드
	private String name;
	private int age;
	private char gender;

	public Person() { // 기본생성자

	}

	public Person(String name, int age, char gender) {
		// 매개변수가 있는 생성자
		this.name = name;
		this.age = age;
		this.gender = gender;

	}

	// getter setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return  age;
	}
	public void setAge(int age) {
		this.age=age;
	}
	
	public char getGender() {
		return gender;
	}
	
	public void  setGender(char gender) {
		this.gender=gender;
	}

}
