package Ex1.test;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Rub {

		public static void main(String[] args) {
			int horse = 0;
			int money = 0;
			int battingMoney = 0;
			int moneyPlus = 0;
			int sel = 0;
			Consol consol = new Consol();

			Scanner scan = new Scanner(System.in);
			����: while (true) {
				try {
					consol.extracted();
					sel = scan.nextInt(); // �޴��Է¹���
				} catch (InputMismatchException e) {// ���� ���� �ٸ����� �������� �����޼����� ����ϰ� while������ ���ư���.
					System.out.println("�߸��� �Է��Դϴ�.");
					scan.next();
					continue;
				}
				switch (sel) {
				case 1:

					do {
						try {
							horse = consol.horseChoice(scan);
							if (horse <= 0 || horse > 3) { // 1~3�� �Է����� �ʾ�����
								System.out.println("�߸��Է��ϼ̽��ϴ�.");
								// �ݺ����� �����ϰ� ó������ ���ư���

							}
						} catch (InputMismatchException ex) {// ���� ���� �ٸ����� �������� �����޼����� ����ϰ� while������ ���ư���.
							System.out.println("�߸��� �Է��Դϴ�.");
							scan.next();
							continue;
						}

					} while (horse <= 0 || horse > 3);

					while (true) {
						try {
							System.out.print("�󸶸� �����Ͻðڽ��ϱ�?");
							battingMoney = scan.nextInt(); // ������ ���Է�
							if (money < battingMoney) {// ���� money���� ���ð��� ������
								System.out.println("�ܾ��� �����մϴ�.");
								break; // �ݺ��� ����
							} else if (battingMoney <= 0) {
								System.out.println("1���̻� �������ּ���");
								break;
							}

							Random random = new Random();
							int victory = random.nextInt(3) + 1; // ������ 1~3������ ���� �������� ��µȴ�.
							System.out.println(victory + "���� ����Ͽ����ϴ�.");
							if (horse == victory) {// �������� ������
								System.out.println("���ÿ� �����Ͽ����ϴ�...!");
								System.out.println("������ �ݾ��� 2���� " + battingMoney * 2 + "���� ȹ���Ͽ����ϴ�");
								money = money + battingMoney; // ���ð��� ���� �ʾ������� ���ð���ŭ�� �����ش�.
							} else {
								System.out.println("���ÿ� �����Ͽ����ϴ�...^^");
								System.out.println("������ �ݾ��� " + battingMoney + "���� ��� �����̽��ϴ�");
								money = money - battingMoney; // ���ð��� money���� �A��.
							}
						} catch (InputMismatchException e) {// ���� ���� �ٸ����� �������� �����޼����� ����ϰ� while������ ���ư���.
							System.out.println("�߸��� �Է��Դϴ�.");
							scan.next();
							continue;
						}
						break;
					}
					break;

				case 2:
					while (true) {
						try {
							money = consol.moneyPlus(money, scan);
							break;
						} catch (InputMismatchException e) {// ���� ���� �ٸ����� �������� �����޼����� ����ϰ� while������ ���ư���.
							System.out.println("�߸��� �Է��Դϴ�.");
							scan.next();
							continue;
						}
					}
					break;
				case 3:
					System.out.println("���� �ܾ��� : " + money + "�� �Դϴ�.");// ���� money�� ����Ѵ�.
					break;
				case 4:
					System.out.println("�����մϴ�.");
					break ����;
				default:// �������� 1~4�� �ƴҶ� ������ �����޼���
					System.out.println("�߸� �Է��ϼ̽��ϴ�.");
					break;
				}

			}

		}

		

		

	}


