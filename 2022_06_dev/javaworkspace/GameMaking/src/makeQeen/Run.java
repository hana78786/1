package makeQeen;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Run {
	public static void main(String[] args) {
		GamePrint gp = new GamePrint();

		try {

			System.out.println(">>>>>>>>>>>>>>>�� ����Ŀ <<<<<<<<<<<<<<<");
			Thread.sleep(500);
			System.out.println("------------������ �����մϴ�!-------------");
			Thread.sleep(500);
			System.out.println("����� ���ִ��� ���簡 �Ǿ� ���ִ��� �������� Ű��� �˴ϴ�!");
			Thread.sleep(300);
			System.out.println("���ִ��� 15��, ������ 5�⵿�� �Ǹ��� �������� Ű�����°��� ��ǥ�Դϴ�.");
			Thread.sleep(300);
			System.out.println("�������� 1�⿡ 3�� �б⸶�� �ۼ��մϴ�");
			Thread.sleep(300);
			System.out.println("���ִ��� �������� ��������!");
			Thread.sleep(300);
			System.out.println("----------------------------------------");
			System.out.println("----------------------------------------");
			System.out.println("----------------------------------------");
			Scanner scan = new Scanner(System.in);
			gp.prinPrint();
			���� : while (gp.turn < 64) { // ���� 60�ϱ��� �۵������� ���� �ϳ��� ���� �˳��ϰ� ���� ��ô�
				
				if (gp.month == 13) { // ���� 13�� �Ǹ� 1�� �ʱ�ȭ �ϰ� ���̸� �ѻ� �Դ´�
					gp.month = 1;
					gp.year++;
					
				}
				if(gp.year==20) { //���̰� 20���� �Ǹ� �����Ѵ�
					break ����;
				}
				else {
				
				System.out.println("-----------------------------------------");
				System.out.println("���� ���� " + gp.year + "�� " + gp.month + "��");
				System.out.println("������ �ұ��?");
				System.out.println("1. �ɷ�ġ�� Ȯ���Ѵ�");
				System.out.println("2. �������� �ۼ��Ѵ�.");
				System.out.println("3. ������ ����.");
				try {
					int sel = scan.nextInt();
					if (sel == 1) {
//						gp.printParameter(); //���� �ɷ�ġ�� �����ִ�
					} else if (sel == 2) {
//						gp.schedule(); // �������� �ۼ��Ѵ�
						
					} else if (sel == 3) {
//						gp.store(); // �������� ����
						
					} else {
						System.out.println("�߸������̽��ϴ�"); //�޴��� �ٽ� ���´�
					}
				} catch (InputMismatchException e) { // �߸��Է½� �޴��ݺ�
					System.out.println("�߸��� �Է��Դϴ�.");
					scan.next();
					continue;
				}
				}

			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		gp.ending();
		
		
		
	}

}

