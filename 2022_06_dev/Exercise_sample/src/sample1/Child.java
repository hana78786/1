package sample1;

public class Child extends Parent{
	private int num = 100;
	
	public Child() {}

	public void out() {
		System.out.println("�θ��� protected num �ʵ� : "+num);
		System.out.println("�ڽ� Ŭ������ �޼ҵ�");
	}
	
	//@Override
	public void display() {
		System.out.println("��ӹ޾� �������� �޼ҵ�");
	}
	
}
