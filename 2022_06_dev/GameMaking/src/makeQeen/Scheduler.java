package makeQeen;

import make.qeen.GamePrint;

public class Scheduler {
	// �������� �����Ű�� Ŭ�����Դϴ�.
	// �����ʹ� ���⿡ ���ֽ��ϴ�.
	GamePrint gp = new GamePrint();
	Parameter pm = new Parameter();

	public int money = 200;
	public int power;
	public int music;
	public int cook;
	public int strong;
	public int manner;
	public int art;
	public int freindly;
	public int study;
	public int stress;

	// �Ƹ�����Ʈ
	public int farm;
	public int cafe;
	public int child;

	// ����
	public int martial;
	public int artSchool;
	public int musicSchool;

	public void farm() { // ����˹�
		System.out.println("--------------------");
//		try {
//			Thread.sleep(100);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		try {
//			Thread.sleep(100);
//			if (stress >= 100) {// ��Ʈ������ ������ ���� �޽�
//				System.out.println("��Ʈ������ �ʹ� �����ϴ�");
//				System.out.println("�̹� �������� �޽��մϴ�.");
//				rest();
//			} else {
//				power += 2;
//				strong += 2;
//				money += 20;
//				farm++;
//				
//	
//				System.out.println("���� 2 �����߽��ϴ�.");
//				System.out.println("�ټ��� 2 �����߽��ϴ�.");
//				System.out.println("���� 20g �����߽��ϴ�.");
//
//			}
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		stress += 5;
//		System.out.println("--------------------");
	}

	

	public void cafe() {// ī��˹�
		System.out.println("--------------------");
//		try {
//			Thread.sleep(100);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		if (stress >= 100) {// ��Ʈ������ ������ ���� �޽�
//			System.out.println("��Ʈ������ �ʹ� �����ϴ�");
//			System.out.println("�̹� �������� �޽��մϴ�.");
//			rest();
//		} else {
//			cook += 2;
//			strong += 2;
//			money += 15;
//			cafe++;
//			stress += 5;
//
//			System.out.println("�丮�� 2 �����߽��ϴ�.");
//			System.out.println("�ټ��� 2 �����߽��ϴ�.");
//			System.out.println("���� 15g �����߽��ϴ�.");
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println("--------------------");
//
//		}
	}

	public void child() {// ����˹�
		System.out.println("--------------------");
//		try {
//			Thread.sleep(100);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		if (stress >= 100) {// ��Ʈ������ ������ ���� �޽�
//			System.out.println("��Ʈ������ �ʹ� �����ϴ�");
//			System.out.println("�̹� �������� �޽��մϴ�.");
//			rest();
//		} else {
//			strong += 2;
//			manner += 1;
//			study += 1;
//			money += 15;
//			child++;
//
//			stress += 5;
//
//			System.out.println("���� 2 �����߽��ϴ�.");
//			System.out.println("������ 1 �����߽��ϴ�.");
//			System.out.println("�з��� 1 �����߽��ϴ�.");
//			System.out.println("���� 15g �����߽��ϴ�.");
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println("--------------------");
//
//		}
	}

	public void artschool() {// �̼�����
		System.out.println("--------------------");
//		try {
//			Thread.sleep(100);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		if (stress >= 100) {// ��Ʈ������ ������ ���� �޽�
//			System.out.println("��Ʈ������ �ʹ� �����ϴ�");
//			System.out.println("�̹� �������� �޽��մϴ�.");
//			rest();
//		} else {
//
//			if (money < 50) {// ���� �����ϸ� ���� �޽�
//				System.out.println("���� �����մϴ�.");
//				System.out.println("�̹� �������� �޽��մϴ�.");
//				rest();
//
//			} else {
//				art += 5;
//				study += 2;
//				strong += 2;
//				money -= 50;
//
//				artSchool++;
//
//				stress += 5;
//				System.out.println("�̼��� 5 �����߽��ϴ�.");
//				System.out.println("�з��� 2 �����߽��ϴ�");
//				System.out.println("���� 2 �����߽��ϴ�");
//				System.out.println("���� 50g �����߽��ϴ�");
//
//			}
//		}
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("--------------------");
	}

	public void musicschool() {// ���ǰ���
//		System.out.println("--------------------");
//		try {
//			Thread.sleep(100);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		if (stress >= 100) {// ��Ʈ������ ������ ���� �޽�
//			System.out.println("��Ʈ������ �ʹ� �����ϴ�");
//			System.out.println("�̹� �������� �޽��մϴ�.");
//			rest();
//		} else {
//			if (money < 50) {// ���� �����ϸ� ���� �޽�
//				System.out.println("���� �����մϴ�.");
//				System.out.println("�̹� �������� �޽��մϴ�.");
//				rest();
//
//			} else {
//				music += 5;
//
//				study += 2;
//
//				manner += 2;
//
//				money -= 50;
//
//				musicSchool++;
//				pm.setFarm(musicSchool);
//				stress += 5;
//				System.out.println("������ 5 �����߽��ϴ�.");
//				System.out.println("�з��� 2 �����߽��ϴ�");
//				System.out.println("������ 2 �����߽��ϴ�");
//				System.out.println("���� 50g �����߽��ϴ�");
//
//			}
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println("--------------------");
//		}
	}

	public void martial() {// ��������
//		System.out.println("--------------------");
//		try {
//			Thread.sleep(100);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		if (stress >= 100) {// ��Ʈ������ ������ ���� �޽�
//			System.out.println("��Ʈ������ �ʹ� �����ϴ�");
//			System.out.println("�̹� �������� �޽��մϴ�.");
//			rest();
//		} else {
//			if (money < 50) {// ���� �����ϸ� ���� �޽�
//				System.out.println("���� �����մϴ�.");
//				System.out.println("�̹� �������� �޽��մϴ�.");
//				rest();
//
//			} else {
//				power += 5;
//
//				strong += 2;
//
//				study += 2;
//
//				money -= 50;
//
//				martial++;
//
//				stress += 5;
//				System.out.println("���� 5 �����߽��ϴ�.");
//				System.out.println("�з��� 2 �����߽��ϴ�");
//				System.out.println("�ټ��� 2 �����߽��ϴ�");
//				System.out.println("���� 50g �����߽��ϴ�");
//			}
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println("--------------------");
//		}
	}

	public void rest() {// �޽�
		System.out.println("--------------------");
//		try {
//			Thread.sleep(100);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("�޽��� �����մϴ�.");
//		System.out.println("��Ʈ������ 20�����մϴ�.");
//		stress -= 20;
//		if (stress <= 0) {
//			stress = 0;
//		}
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("--------------------");
	}
}
