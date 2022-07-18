package com.kh.domain;

public class Student {
	private String name;
	private int score;
	
	public Student() {
		
	}
	
	public Student(String name, int score) {
		this.name =name;
		this.score=score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
	
	
	
	//객체비교
	//객체와 객체를 비교하면 객체가 가지고 있는 값을
	//비교해줘야 한다
	//그렇지 않으면 주소값을 비교함.. 그렇게 되면
	//다르다고 만 나옴
	
	
	
	@Override
	public String toString(){
		return "Strudnet [name=" + name +", score "+ score +"]";
		
		
	}
	
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return (this.name+this.score).hashCode();
		//객체의 주소값으로 변하지 않고 고유값으로 비교해서 같은지 확인
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		//객체인 경우에도 중복으로 저장되지 않기 위해서
		//equals() 메소드를 재정의하여 비교하도록 함
		if(obj instanceof Student) {
			Student std = (Student)obj;
			return this.hashCode() == std.hashCode();
		
		}else {
			return false;
		}
	}
	
}
