package com.kh.map;

import java.util.HashMap;
import java.util.Map;

import com.kh.domain.Student;

public class Run {
public static void main(String[] args) {
	Map<String, String> map = new HashMap<String, String>();
	map.put("02","서울");
	map.put("031","경기도");
	map.put("061","전라도");
	map.put("053","대구");
	 
	System.out.println("02를 누르면 서울이 나옵니다 : "+map.get("02"));
	System.out.println("031을 누르면 경기도가 나옵니다 : "+map.get("031"));
	System.out.println("저장된 데이터의 수 :"+map.size());
	System.out.println();
	
	Map<String, Object> objMap = new HashMap<String, Object>();
	objMap.put("name","소지섭");
	objMap.put("score",100);
	objMap.put("isReal",true);
	
	System.out.println("이름 "+objMap.get("name"));
	System.out.println("점수 "+objMap.get("score"));
	System.out.println("진짜인지 "+objMap.get("isReal"));
	System.out.println();
	
	Map<Integer,Student> stdMap=new HashMap<Integer,Student>();
	stdMap.put(1,new Student("손예진",100));
	stdMap.put(2, new Student("공효진", 99));
	stdMap.put(3, new Student("김효진",98));
	stdMap.put(4, new Student("손예진",100));
	
	System.out.println(stdMap.get(1));
	System.out.println(stdMap.get(2));
	System.out.println(stdMap.get(3));
	System.out.println(stdMap.get(4));
}

}
