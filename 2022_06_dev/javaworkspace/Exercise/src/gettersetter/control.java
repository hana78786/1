package gettersetter;

public class control {
	gettersetter gs = new gettersetter();
	int power;
	int age;
	
	public control() {
		
	}
	
	public gettersetter power() {
		System.out.println("���ִ��� ��� �մϴ� �� +10");
		power =gs.getPower()+10;
		gs.setPower(power);
		System.out.println(gs.getPower());
	return gs;
	}
	public gettersetter age() {
		System.out.println("���ִ��� ���̸� �Խ��ϴ� ����+5");
		age = gs.getAge()+5;
		gs.setAge(age);
		System.out.println(gs.getAge());
		return gs;

	}
	
	public void print() {
		System.out.println("��"+power+" "+"����"+age);
	}



}
