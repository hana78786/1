package com.kn.run;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.kh.domain.Student;

public class Run {
	public static void main(String[] args) {
		List<Integer> list;

		list = new ArrayList<Integer>();

		list.add(6);
		list.add(13);

		int size = list.size();

		System.out.println("size : " + size);

		list.clear();
		size = list.size();
		System.out.println("size : " + size);

		// list.add("100"); //문자열 사용하면 오류!

		list.add(100);
		list.add(200);
		list.add(45);
		list.add(-75);
		list.add((int) 10.2);
		
		list.remove(0);
		list.add(0, 5);
		
		for(int i=0; i<list.size();i++) {
			System.out.println((i+1)+"번째 : "+list.get(i));
		}
		
		System.out.println("데이터 nullcheck "+list.isEmpty());
		list.clear();
		System.out.println("데이터 nullcheck "+list.isEmpty());
		
		
		Set<Student> stdSet = new HashSet<Student>();
		Student stdOne = new Student();
		stdOne.setName("강동원");
		stdOne.setScore(100);
		stdSet.add(stdOne);
		stdSet.add(new Student("소집섭",99));
		stdSet.add(new Student("조인성", 98));
		stdSet.add(new Student("정우성", 100));
		stdSet.add(new Student("정우성", 100));
		Iterator<Student> it = stdSet.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next().toString());
		}
		
		
//		for(int i =0; i<set.size();i++) {
//			
//		}
	}
}
