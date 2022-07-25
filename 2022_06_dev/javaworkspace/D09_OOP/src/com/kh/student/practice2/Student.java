package com.kh.student.practice2;

public class Student {
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private double avr;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getTotal() {
		total = kor+eng+math;
		return total;
	}


	public double getAvr() {
		avr = getTotal()/3.0;
		return avr;
	}


	public Student() {
		
	}

}
