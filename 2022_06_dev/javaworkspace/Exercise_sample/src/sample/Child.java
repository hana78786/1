package sample;

public class Child extends Parent {
	public void out() {
		System.out.println("자식 클래스");
	}
	
	//@Override
	public void display() {
		System.out.println("상속받은 오버라이드!");
	}
	
}
