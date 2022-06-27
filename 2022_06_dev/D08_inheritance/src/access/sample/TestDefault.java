package access.sample;

import com.kh.exercise.DefaultSample1;

public class TestDefault {
	public static void main(String[] args) {
	DefaultSample1 dt1 = new DefaultSample1();
	DefaultSample2 dt2 = new DefaultSample2();
	
//	dt1.num1=100;
	dt2.num2=100;
//	System.out.println(dt1.num1); //다른패키지 이동시 접근불가능
	System.out.println(dt2.num2);
	}
	
}
