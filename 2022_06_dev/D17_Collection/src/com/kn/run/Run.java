package com.kn.run;

import java.util.ArrayList;
import java.util.List;

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
	}
}
