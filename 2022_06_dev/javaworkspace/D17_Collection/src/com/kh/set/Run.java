package com.kh.set;

import java.util.HashSet;
import java.util.Set;

public class Run {
public static void main(String[] args) {
	//set의 특징
	//저장된 값의 순서를 유지하지 않고 중복을 허용하지 않음
	//순서가 없으므로  index로 접근 불가능하며
	//iterator를 이용하여 요소에 접근 가능함
	
	Set<String> set = new HashSet<String>();
	set.add("one");
	set.add("two");
	set.add("three");
	set.add("one");
	set.add("two");
	
	System.out.println("저장이된 데이터의 수 : "+set.size());
	
	set.clear();
	System.out.println("저장된 데이터의 수 : "+set.size());
	set.add("1");
	set.add("2");
	System.out.println("데이터가 있는지 "+ !set.isEmpty());
	
	
}
}
