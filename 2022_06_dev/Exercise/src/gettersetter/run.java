package gettersetter;

public class run {
	public static void main(String[] args) {
		control ct = new control();
		ct.power();
		ct.age();
		ct.power();
		ct.age();
		ct.power();
		ct.age();
		
		System.out.println("공주님의 능력치를 확인합니다");
		
		ct.print();
	}

}
