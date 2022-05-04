package oop;
class print{
	public static String del;
	public static void A() {
		System.out.println(del);
		System.out.println("A");
		System.out.println("A");
	}

	public static void B() {
		System.out.println(del);
		System.out.println("B");
		System.out.println("B");
	}
	

public class MyOOp {
	public static void main(String[] args) {
		print.del="----";
		print.A();	
		print.B();
		
		print.del="****";
		print.A();	
		print.B();
	}

	
}
