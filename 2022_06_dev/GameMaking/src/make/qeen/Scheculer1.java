package make.qeen;

public class Scheculer1 {


	int money = 200;
	int power;
	int music;
	int cook;
	int strong;
	int manner;
	int art;
	int freindly;
	int study;
	int stress;

	// �Ƹ�����Ʈ
	int farm;
	int cafe;
	int child;

	// ����
	int martial;
	int artSchool;
	int musicSchool;
	


	public void farm() {// ����˹�
		System.out.println("--------------------");
		try {
			Thread.sleep(500);

		if (stress >= 100) {// ��Ʈ������ ������ ���� �޽�
			System.out.println("��Ʈ������ �ʹ� �����ϴ�");
			System.out.println("�̹� �������� �޽��մϴ�.");
			Thread.sleep(500);
			rest();

		} else {
			power += 2;
			strong += 2;
			money += 20;
			farm++;
			

			System.out.println("���� 2 �����߽��ϴ�.");
			System.out.println("�ټ��� 2 �����߽��ϴ�.");
			System.out.println("���� 20g �����߽��ϴ�.");
			Thread.sleep(500);

			stress += 5;
			System.out.println("--------------------");

		}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void cafe() {// �Ĵ�˹�
		System.out.println("--------------------");
		try {
			Thread.sleep(500);

			if (stress >= 100) {// ��Ʈ������ ������ ���� �޽�
				System.out.println("��Ʈ������ �ʹ� �����ϴ�");
				System.out.println("�̹� �������� �޽��մϴ�.");
				Thread.sleep(500);
				rest();
			} else {
				cook += 2;
				strong += 2;
				money += 15;
				cafe++;
				stress += 5;

				System.out.println("�丮�� 2 �����߽��ϴ�.");
				System.out.println("�ټ��� 2 �����߽��ϴ�.");
				System.out.println("���� 15g �����߽��ϴ�.");
				Thread.sleep(500);

				System.out.println("--------------------");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void child() {// ����˹�
		System.out.println("--------------------");
		try {
			Thread.sleep(500);

			if (stress >= 100) {// ��Ʈ������ ������ ���� �޽�
				System.out.println("��Ʈ������ �ʹ� �����ϴ�");
				System.out.println("�̹� �������� �޽��մϴ�.");
				Thread.sleep(500);
				rest();
			} else {
				strong += 2;
				manner += 1;
				study += 1;
				money += 15;
				child++;

				stress += 5;

				System.out.println("���� 2 �����߽��ϴ�.");
				System.out.println("������ 1 �����߽��ϴ�.");
				System.out.println("�з��� 1 �����߽��ϴ�.");
				System.out.println("���� 15g �����߽��ϴ�.");
				Thread.sleep(500);
				System.out.println("--------------------");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void artschool() {// �̼�����
		System.out.println("--------------------");
		try {
			Thread.sleep(500);

			if (stress >= 100) {// ��Ʈ������ ������ ���� �޽�
				System.out.println("��Ʈ������ �ʹ� �����ϴ�");
				System.out.println("�̹� �������� �޽��մϴ�.");
				Thread.sleep(500);
				rest();
			} else {

				if (money < 50) {// ���� �����ϸ� ���� �޽�
					System.out.println("���� �����մϴ�.");
					System.out.println("�̹� �������� �޽��մϴ�.");
					Thread.sleep(500);
					rest();

				} else {
					art += 5;
					study += 2;
					strong += 2;
					money -= 50;

					artSchool++;

					stress += 5;
					System.out.println("�̼��� 5 �����߽��ϴ�.");
					System.out.println("�з��� 2 �����߽��ϴ�");
					System.out.println("���� 2 �����߽��ϴ�");
					System.out.println("���� 50g �����߽��ϴ�");
					Thread.sleep(500);

					System.out.println("--------------------");

				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void musicschool() {// ���ǰ���
		System.out.println("--------------------");
		try {
			Thread.sleep(500);

			if (stress >= 100) {// ��Ʈ������ ������ ���� �޽�
				System.out.println("��Ʈ������ �ʹ� �����ϴ�");
				System.out.println("�̹� �������� �޽��մϴ�.");
				Thread.sleep(500);
				rest();
			} else {
				if (money < 50) {// ���� �����ϸ� ���� �޽�
					System.out.println("���� �����մϴ�.");
					System.out.println("�̹� �������� �޽��մϴ�.");
					Thread.sleep(500);
					rest();

				} else {
					music += 5;

					study += 2;

					manner += 2;

					money -= 50;

					musicSchool++;
					stress += 5;
					System.out.println("������ 5 �����߽��ϴ�.");
					System.out.println("�з��� 2 �����߽��ϴ�");
					System.out.println("������ 2 �����߽��ϴ�");
					System.out.println("���� 50g �����߽��ϴ�");
					Thread.sleep(500);
					System.out.println("--------------------");
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void martial() {// ��������
		System.out.println("--------------------");
		try {
			Thread.sleep(500);
			if (stress >= 100) {// ��Ʈ������ ������ ���� �޽�
				System.out.println("��Ʈ������ �ʹ� �����ϴ�");
				System.out.println("�̹� �������� �޽��մϴ�.");
				Thread.sleep(500);
				rest();
			} else {
				if (money < 50) {// ���� �����ϸ� ���� �޽�
					System.out.println("���� �����մϴ�.");
					System.out.println("�̹� �������� �޽��մϴ�.");
					Thread.sleep(500);
					rest();

				} else {
					power += 5;

					strong += 2;

					study += 2;

					money -= 50;

					martial++;

					stress += 5;
					System.out.println("���� 5 �����߽��ϴ�.");
					System.out.println("�з��� 2 �����߽��ϴ�");
					System.out.println("�ټ��� 2 �����߽��ϴ�");
					System.out.println("���� 50g �����߽��ϴ�");
					Thread.sleep(500);
					System.out.println("--------------------");

				}
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void rest() {// �޽�

		System.out.println("--------------------");
		try {
			Thread.sleep(500);
			System.out.println("�޽��� �����մϴ�.");
			System.out.println("��Ʈ������ 20�����մϴ�.");
			stress -= 20;
			if (stress <= 0) {
				stress = 0;
			}
			System.out.println("--------------------");
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
