package MemberControl.copy;

import java.util.InputMismatchException;
import java.util.List;

public class Run {
	public static void main(String[] args) {

		MemberView mv = new MemberView();
		Control cont = new Control();

//		System.out.println("1. ȸ������ ��ü��ȸ");
//		System.out.println("2. ȸ�� ���̵�� ��ȸ");
//		System.out.println("3. ȸ�� �̸����� ��ȸ");
//		System.out.println("4. ȸ�� ����");
//		System.out.println("5. ȸ�� ���� ����");
//		System.out.println("6. ȸ��Ż��");
//		System.out.println("0. ���α׷� ����");

		exit: while (true) {
			int choice = mv.pirntMenu();
			switch (choice) {
			case 1:
				System.out.println("ȸ����ü��ȸ");
				List<Member> mList = cont.allMember();
				mv.printAllMember(mList);
				break;
			case 2:
				System.out.println("���̵� �Է��ϼ���");
				// ���̵��� �Է¹޴´�
				String id = mv.serchId();
				// ���̵��� for������ �˻��ϰ� ���̵� �ִ� �ε��� ���� ã�´�
				int index = cont.serchIdIndex(id);
				if (index == -1) {
					System.out.println("�˻�����");
					break;
				}
				// �� �ε��� ���� �޾� member�� ����Ѵ�
				Member member = cont.suchIdPrint(index);
				mv.printSerchId(member);

				break;
			case 3:
				System.out.println("�̸��� �Է��ϼ���");
				String name = mv.serchName();
				index = cont.serchNameIndex(name);
				if (index == -1) {
					System.out.println("�˻�����");
					break;
				}
				// �� �ε��� ���� �޾� member�� ����Ѵ�
				member = cont.suchIdPrint(index);
				mv.printSerchId(member);
				break;
			case 4:
				member = mv.memberPlus();
				cont.addlist(member);
				break;
			case 5:
				System.out.println("������ �����մϴ�");
				System.out.println("���̵� �Է��ϼ���");
				
				id = mv.serchId();
				// ���̵��� for������ �˻��ϰ� ���̵� �ִ� �ε��� ���� ã�´�
				index = cont.serchIdIndex(id);
				if (index == -1) {
					System.out.println("�˻�����");
					break;
				}
				// �� �ε��� ���� �޾� member�� ����Ѵ�
				member = cont.suchIdPrint(index);
				mv.chageMemberInfo(member);
				
				
				break;
			case 6:
				System.out.println("Ż��޴��Դϴ�");
				System.out.println("Ż���� ���̵� �Է��ϼ���");
				
				id = mv.serchId();
				// ���̵��� for������ �˻��ϰ� ���̵� �ִ� �ε��� ���� ã�´�
				index = cont.serchIdIndex(id);
				if (index == -1) {
					System.out.println("�˻�����");
					break;
				}
				cont.remove(index);
				
				
				break;
			case 0:
				break exit;
			default:
				break;
			}
		}

	}

}
