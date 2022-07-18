package collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Exer {

	public static void main(String[] args) {
//		exercise1();
//		exercise2();
		exercise3();
	}

	public static void exercise1() {
		List list;

		list = new ArrayList();
		Student student = new Student();
		student.setName("남쿠리");
		student.setScore(100);

		list.add("안녕");
		list.add(1 + 1);
		list.add(student);
		list.add(1 + 1);
		list.add(student);

		String a = (String) list.get(0);
		int b = (int) list.get(1);
		int c = (int) list.get(3);

		System.out.println(a + b + c);

		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		System.out.println(list.get(4));

	}

	public static void exercise2() {
		List<String> list;
		list = new ArrayList<String>();
		
		list.add("이건 문자열만 가능하지!");
		list.add("이건 몇번째 인덱스?");
		list.add(0,"이건 0번째 인덱스!");
		list.remove(0);
		list.clear();
		
		System.out.println("0"+list.get(0));
		System.out.println("1"+list.get(1));
		System.out.println("2"+list.get(2));
		
	}

	
	public static void exercise3() {
	Student std = new Student();
	Set<Student> list = new HashSet<Student>();
	std.setName("0");
	std.setScore(100);
	list.add(std);
	list.add(new Student("2",100));
	list.add(new Student("1",50));
	Iterator<Student> it = list.iterator();
	
	while(it.hasNext()) {
		System.out.println(it.next());
	}
	System.out.println(list.size());
	list.clear();
	System.out.println(list.size());
	System.out.println(list.isEmpty());

	}
}
