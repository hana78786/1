package MemberControl;

import java.util.List;
import java.util.Scanner;

public class MemberView {
Scanner scan = new Scanner(System.in);
	public int pirntMenu() {
		Scanner scan = new Scanner(System.in);

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
		Member mb = new Member();
		System.out.println("���̵�");
		mb.setId(scan.next());
		System.out.println("�̸�");
		mb.setName(scan.next());
		System.out.println("����");
		mb.setAge(scan.nextInt());
		
		return mb;
		
	}
	public void printall(List<Member> mList) {
		// TODO Auto-generated method stub
		for(int i =0;i<mList.size();i++) {
			Member mem = mList.get(i);
			System.out.println("�̸� : "+mem.getName());
			System.out.println("id : "+mem.getId());
			System.out.println("���� : "+mem.getAge());
			System.out.println("=====================");
		}
		
	}
	public String inputId() {
		System.out.println("�˻��� ���̵� �Է�");
		String Id = scan.next();
		return Id;
	}
	public void printSerchId(Member member) {
		// TODO Auto-generated method stub
		System.out.println("�̸� : "+member.getName());
		System.out.println("id : "+member.getId());
		System.out.println("���� : "+member.getAge());
		System.out.println("=====================");
		
		
	}
	public String inputName() {
		// TODO Auto-generated method stub
		System.out.println("�˻��� �̸� �Է�");
		String Name = scan.next();
		return Name;
		
	}
	public void chageMemberInfo(Member member) {
		System.out.println("�Է��� ���̵��� ������ �����մϴ�");
		System.out.print("�̸� : ");
		member.setName(scan.next());
		System.out.println("���� : ");
		member.setAge(scan.nextInt());
		
	}
	
	
	
}
