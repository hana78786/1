package MemberControl;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Run {
	public static void main(String[] args) {

		MemberView mv = new MemberView();
		Member member = new Member();
		Control cont = new Control();

//		System.out.println("1. ȸ������ ��ü��ȸ");
//		System.out.println("2. ȸ�� ���̵�� ��ȸ");
//		System.out.println("3. ȸ�� �̸����� ��ȸ");
//		System.out.println("4. ȸ�� ����");
//		System.out.println("5. ȸ�� ���� ����");
//		System.out.println("6. ȸ��Ż��");
//		System.out.println("0. ���α׷� ����");

	exit:	while (true) {
			try {
				int choice = mv.pirntMenu();
				switch (choice) {
				case 1:
					System.out.println("��ü ��ȸ");
					
					ArrayList<Member>mList=cont.allMember();
					mv.printall(mList);
					break;
				case 2:
					System.out.println("���̵�� ��ȸ");
					//�� �ε������� �ִ� id�� �Է�id�� ������ ���Ѵ�
					//���� id�� �ִ� �ε��� ���� ������ �ͼ� ����Ѵ�
					//������ ���и޼���
					String id = mv.inputId();
					int index = cont.serchId(id);
					if(index==-1) {
						System.out.println("�˻��������");
					break;
					}
					member = cont.serchPrintId(index);
					mv.printSerchId(member);
					break;
				case 3:
					String Name = mv.inputName();
					index = cont.serchName(Name);
					if(index==-1) {
						System.out.println("�˻��������");
						break;
					}
					member = cont.serchPrintId(index);
					mv.printSerchId(member);
					
					
					break;
				case 4:
					System.out.println("ȸ������");
					member = mv.memberPlus();
					cont.addList(member);
					break;
				case 5:
					id = mv.inputId();
					index = cont.serchId(id);
					if(index==-1) {
						System.out.println("�˻��������");
					break;
					}
					member = cont.serchPrintId(index);
					mv.chageMemberInfo(member);
					
					break;
				case 6:
					id = mv.inputId();
					index = cont.serchId(id);
					if(index==-1) {
						System.out.println("�˻��������");
					break;
					}
					System.out.println("���̵� Ż���մϴ�.");
					cont.remove(index);
					System.out.println("Ż�� �Ϸ�Ǿ����ϴ�.");
					break;
				case 0:
					break exit;
				default:
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("�Է¿���");
				break;
			}
		}

	}

}
