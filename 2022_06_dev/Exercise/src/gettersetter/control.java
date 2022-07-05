package gettersetter;

public class control {
	gettersetter gs = new gettersetter();
	int power;
	int age;
	
	public void power() {
		System.out.println("공주님이 운동을 합니다 힘 +10");
		power =gs.getPower()+10;
		gs.setPower(power);
		System.out.println(gs.getPower());
	
	}
	public void age() {
		System.out.println("공주님이 나이를 먹습니다 나이+5");
		age = gs.getAge()+5;
		gs.setAge(age);
		System.out.println(gs.getAge());

	}
	
	public void print() {
		System.out.println("힘"+power+" "+"나이"+age);
	}

}
