package com.kh.set;

import java.util.HashSet;
import java.util.Set;

public class Run {
public static void main(String[] args) {
	//set�� Ư¡
	//����� ���� ������ �������� �ʰ� �ߺ��� ������� ����
	//������ �����Ƿ�  index�� ���� �Ұ����ϸ�
	//iterator�� �̿��Ͽ� ��ҿ� ���� ������
	
	Set<String> set = new HashSet<String>();
	set.add("one");
	set.add("two");
	set.add("three");
	set.add("one");
	set.add("two");
	
	System.out.println("�����̵� �������� �� : "+set.size());
	
	set.clear();
	System.out.println("����� �������� �� : "+set.size());
	set.add("1");
	set.add("2");
	System.out.println("�����Ͱ� �ִ��� "+ !set.isEmpty());
	
	
}
}
