package gettersetter;

public class run {
	public static void main(String[] args) {

		control ct = new control();
		gettersetter gs = ct.power();
		ct.age();
		ct.power();
		ct.age();
		ct.power();
		ct.age();
		
		System.out.println("���ִ��� �ɷ�ġ�� Ȯ���մϴ�");
		

		System.out.println("��"+gs.getPower()+" "+"����"+gs.getAge());
	}

}
