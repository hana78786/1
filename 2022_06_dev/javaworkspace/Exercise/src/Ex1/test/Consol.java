package Ex1.test;

import java.util.Scanner;

public class Consol {
	
	public static void extracted() {
		System.out.println("<<< �渶���ӿ� ���� ���� ȯ���մϴ�. >>>"); // �޴����
		System.out.println("1. ���ӽ���");
		System.out.println("2. �ܾ�����");
		System.out.println("3. �ܾ���ȸ");
		System.out.println("4. ���� ����");
		System.out.println("�޴��� �������ּ���.");
		System.out.print(">>");
	}
	
	public static int horseChoice(Scanner scan) {
		int horse;
		System.out.println("������ �����մϴ�."); // ���� �޴����
		System.out.println("1. ��� ����� ������ ���� �յ� ��");
		System.out.println("2. �̹��� ������ ���� ���� ��");
		System.out.println("3. �ֱ� �������� �ſ��� ��");
		System.out.print("���� �ϰ� ���� ���� �������ּ���. >>");
		horse = scan.nextInt(); // �Է��� ��
		return horse;
	}

	public static int moneyPlus(int money, Scanner scan) {
		int moneyPlus = 0;
		while(moneyPlus <= 0) {
		System.out.print("�󸶸� �����Ͻðڽ��� ? ");	
		moneyPlus = scan.nextInt();// �����ݾ� ����
		if(moneyPlus <= 0) {
			System.out.println("1�� �̻� ���������մϴ�.");
		}
		else {
		System.out.println(moneyPlus + "���� �����Ǿ����ϴ�.");
		money = money + moneyPlus; // �����ݾ׸�ŭ ���Ѵ�.
		}
		}
		return money;
	}

}
