package oop;

class Foo{
	public static String classVar="I class var";
	public String instanceVar="I Instance var";


	public void instanceMethod() {
		System.out.println(classVar);
		System.out.println(instanceVar);
	}


	public static void classMethod() {
		System.out.println(classVar);
//		System.out.println(instanceVar);
	}}
public class StaticApp {

	public static void main(String[] args) {
		System.out.println(Foo.classVar);
//		System.out.println(Foo.instanceVar);
		Foo.classMethod();
//		Foo.instacneMethod();
		
		Foo f1=new Foo();
		f1.classVar="f1 class var";
		f1.instanceVar="f1.instance var";

		Foo f2=new Foo();
		f2.instanceVar="f2 isntance var";
		f2.classVar="f2 class var";
		
		System.out.println(f1.classVar);
		System.out.println(f1.instanceVar);
		System.out.println(f2.classVar);
		System.out.println(f2.instanceVar);
		
		

	}

}
