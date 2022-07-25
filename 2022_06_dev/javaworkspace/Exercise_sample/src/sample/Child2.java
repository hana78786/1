package sample;

public class Child2 extends Parent2{
	public Child2(){
		super();//부모호출
		System.out.println("자식 생성자");
		
	}
	//오버라이드
	public void out() {
		super.out();
		System.out.println("자식아웃");
	}

}
