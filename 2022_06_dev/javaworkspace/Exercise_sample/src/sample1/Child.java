package sample1;

public class Child extends Parent{
	private int num = 100;
	
	public Child() {}

	public void out() {
		System.out.println("부모의 protected num 필드 : "+num);
		System.out.println("자식 클래스의 메소드");
	}
	
	//@Override
	public void display() {
		System.out.println("상속받아 재정의한 메소드");
	}
	
}
