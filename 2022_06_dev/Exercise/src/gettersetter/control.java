package gettersetter;

public class control {
	gettersetter gs = new gettersetter();
	int power;
	int age;
	
	public void power() {
		System.out.println("���ִ��� ��� �մϴ� �� +10");
		power =gs.getPower()+10;
		gs.setPower(power);
		System.out.println(gs.getPower());
	
	}
	public void age() {
		System.out.println("���ִ��� ���̸� �Խ��ϴ� ����+5");
		age = gs.getAge()+5;
		gs.setAge(age);
		System.out.println(gs.getAge());

	}
	
	public void print() {
		System.out.println("��"+power+" "+"����"+age);
	}

}
