package com.kh.controller;

import com.kh.collection.IntList;
import com.kh.collection.ObjectList;
import com.kh.collection.Rlist;
import com.kh.domain.Student;

public class lListController {

	public void listExercise1() {
		int [] nums = new int[3];
		nums[0] =1;
		nums[1] =2;
		nums[2] =3;
		
		
		
		IntList list = new IntList();
		list.add(1);
		list.add(2);
		list.add(3);
		
		System.out.println(list.get(0));
		System.out.println(list.size());
		list.clear();
		
		
	}
	
	public void listExercise2() {

		ObjectList objList = new ObjectList();
		objList.add(6);
		objList.add("Collection");
		Student std = new Student();
		objList.add(std);
		objList.add(new Student());
		
		
		//Object List에서 값 가져오기
		int num;
		String str;
		Student stdOne;
		
	num = (int)objList.get(0);
	str = (String)objList.get(1);
	stdOne = (Student)objList.get(2);
		
		
		
	}

	
	public void listExercise3() {
		Rlist<Integer> objList = new Rlist<Integer>();
		objList.add(11);
		objList.add(18);
		
		int num = objList.get(0);
		num= objList.get(1);
		System.out.println("num : "+num);
	}
}
