package com.kh.student.practice;

public class Student {
//값 입력받기
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private double avr;

	public Student() {
	}

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

	public int printTotal() {
		total = math + kor + eng;
		return total;
	}

	public double printAvr() {
		avr = printTotal()/3.0;
		return avr;
	}
//getter setter쓰기
//저장할값은 name, kor, eng, math
//보낼값은 total, avr
}
