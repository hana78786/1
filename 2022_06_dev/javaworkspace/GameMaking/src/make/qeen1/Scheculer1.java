package make.qeen1;

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
	

	
	

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getMusic() {
		return music;
	}

	public void setMusic(int music) {
		this.music = music;
	}

	public int getCook() {
		return cook;
	}

	public void setCook(int cook) {
		this.cook = cook;
	}

	public int getStrong() {
		return strong;
	}

	public void setStrong(int strong) {
		this.strong = strong;
	}

	public int getManner() {
		return manner;
	}

	public void setManner(int manner) {
		this.manner = manner;
	}

	public int getArt() {
		return art;
	}

	public void setArt(int art) {
		this.art = art;
	}

	public int getFreindly() {
		return freindly;
	}

	public void setFreindly(int freindly) {
		this.freindly = freindly;
	}

	public int getStudy() {
		return study;
	}

	public void setStudy(int study) {
		this.study = study;
	}

	public int getStress() {
		return stress;
	}

	public void setStress(int stress) {
		this.stress = stress;
	}

	public int getFarm() {
		return farm;
	}

	public void setFarm(int farm) {
		this.farm = farm;
	}

	public int getCafe() {
		return cafe;
	}

	public void setCafe(int cafe) {
		this.cafe = cafe;
	}

	public int getChild() {
		return child;
	}

	public void setChild(int child) {
		this.child = child;
	}

	public int getMartial() {
		return martial;
	}

	public void setMartial(int martial) {
		this.martial = martial;
	}

	public int getArtSchool() {
		return artSchool;
	}

	public void setArtSchool(int artSchool) {
		this.artSchool = artSchool;
	}

	public int getMusicSchool() {
		return musicSchool;
	}

	public void setMusicSchool(int musicSchool) {
		this.musicSchool = musicSchool;
	}

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
			power = getPower()+2;
			strong += 2;
			money += 20;
			farm++;
			setPower(power);
			

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
