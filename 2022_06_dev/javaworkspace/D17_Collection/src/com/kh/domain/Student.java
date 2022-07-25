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
	
	
	
	
	
	//��ü��
	//��ü�� ��ü�� ���ϸ� ��ü�� ������ �ִ� ����
	//������� �Ѵ�
	//�׷��� ������ �ּҰ��� ����.. �׷��� �Ǹ�
	//�ٸ��ٰ� �� ����
	
	
	
	@Override
	public String toString(){
		return "Strudnet [name=" + name +", score "+ score +"]";
		
		
	}
	
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return (this.name+this.score).hashCode();
		//��ü�� �ּҰ����� ������ �ʰ� ���������� ���ؼ� ������ Ȯ��
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		//��ü�� ��쿡�� �ߺ����� ������� �ʱ� ���ؼ�
		//equals() �޼ҵ带 �������Ͽ� ���ϵ��� ��
		if(obj instanceof Student) {
			Student std = (Student)obj;
			return this.hashCode() == std.hashCode();
		
		}else {
			return false;
		}
	}
	
}
