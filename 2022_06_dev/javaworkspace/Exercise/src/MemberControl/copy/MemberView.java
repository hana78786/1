package MemberControl.copy;

import java.util.List;
import java.util.Scanner;

public class MemberView {
	Scanner scan = new Scanner(System.in);

	public int pirntMenu() {
		System.out.println("================");
		System.out.println("1. ȸ������ ��ü��ȸ");
		System.out.println("2. ȸ�� ���̵�� ��ȸ");
		System.out.println("3. ȸ�� �̸����� ��ȸ");
		System.out.println("4. ȸ�� ����");
		System.out.println("5. ȸ�� ���� ����");
		System.out.println("6. ȸ��Ż��");
		System.out.println("0. ���α׷� ����");
		System.out.print(">>");
		int choice = scan.nextInt();
		return choice;

	}

	public Member memberPlus() {
		// TODO Auto-generated method stub
		System.out.println("ȸ�������� �Է��ϼ���");
		Member member = new Member();
		System.out.print("���̵� :");
		member.setId(scan.next());
		System.out.print("�̸� :");
		member.setName(scan.next());
		System.out.print("���� :");
		member.setAge(scan.nextInt());

		return member;

	}

	public void printAllMember(List<Member> mList) {
		// TODO Auto-generated method stub
		for (int i = 0; i < mList.size(); i++) {
			Member member = mList.get(i);
			System.out.println("���̵� : "+member.getId());
			System.out.println("�̸� : "+member.getName());
			System.out.println("���� : "+member.getAge());
			System.out.println("=============");
		}

	}

	public String serchId() {
		// TODO Auto-generated method stub
		String id = scan.next();
		return id;
	}

	public void printSerchId(Member member) {
		// TODO Auto-generated method stub
		System.out.println("���̵� "+member.getId());
		System.out.println("�̸� "+member.getName());
		System.out.println("���� "+member.getAge());
		
		
	}

	public String serchName() {
		String name = scan.next();
		return name;
	}

	public void chageMemberInfo(Member member) {
		// TODO Auto-generated method stub
		System.out.println("������ �ٽ� �Է��ϼ���");
		System.out.print("�̸� :");
		member.setName(scan.next());
		System.out.print("���� : ");
		member.setAge(scan.nextInt());
		System.out.println("���� ������ �Ϸ�Ǿ����ϴ�.");
		
	}


}
