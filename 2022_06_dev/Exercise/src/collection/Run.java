package collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Run {
	public static void main(String[] args) {
		Map<Integer, Student> map = new HashMap<Integer, Student>();
		map.put(1, new Student("남쿠리",100));
		map.put(2, new Student("남쿠리",100));
		map.put(3, new Student("남메리",100));
		
		Set<Student> Smap= new HashSet<Student>();
		Smap.add(new Student("고양이",10));
		Smap.add(new Student("고양이",10));
		Smap.add(new Student("고양이",200));
		Smap.add(new Student("고양이",20));
		Iterator<Student> it = Smap.iterator();
		
		System.out.println("...");
		while(it.hasNext()) {
			System.out.println(it.next().toString());
		}
		
		
		
		System.out.println();
		
		System.out.println(map.get(1));
		System.out.println(map.get(2));
		System.out.println(map.size());
	
	}

}
