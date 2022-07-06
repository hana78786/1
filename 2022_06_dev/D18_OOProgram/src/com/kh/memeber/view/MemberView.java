package com.kh.memeber.view;

import java.util.List;
import java.util.Scanner;

import com.kh.member.model.vo.Member;

//��´��Ŭ����
public class MemberView {
	Scanner scan = new Scanner(System.in);
	public int mainMenu() {

		System.out.println("======== ȸ������ ���α׷� =========");
		System.out.println("1. ȸ������ ��ü��ȸ");
		System.out.println("2. ȸ�� ���̵�� ��ȸ");
		System.out.println("3. ȸ�� �̸����� ��ȸ");
		System.out.println("4. ȸ�� ����");
		System.out.println("5. ȸ�� ���� ����");
		System.out.println("6. ȸ��Ż��");
		System.out.println("0. ���α׷� ����");
		System.out.print("��ȣ ���� :");
		int choice = scan.nextInt();
		return choice;

	}

	public Member inputMember() {
		Scanner scan = new Scanner(System.in);
		Member member = new Member();
		System.out.println("���̵� : ");
		member.setMemberId(scan.next());
		System.out.println("��й�ȣ : ");
		member.setMemberPwd(scan.next());
		System.out.println("�̸� : ");
		member.setMemberName(scan.next());
		System.out.println("���� : ");
		member.setMemberAge(scan.nextInt());
		System.out.println("���� : ");
		member.setMemberGender(scan.next());
		System.out.println("�̸��� : ");
		member.setMemberEmail(scan.next());
		System.out.println("��ȭ��ȣ : ");
		member.setMemberPhone(scan.next());
		System.out.println("�ּ� : ");
		scan.nextLine();
		member.setMemberAddress(scan.nextLine());
		System.out.println("��� : ");
		member.setMemberHobby(scan.next());

		return member;
	}
	
	
	
	
	public void printAllMember(List<Member>mlist) {
		System.out.println("===== ��ü ȸ�� ���� ��ȸ ��� =====");
		for(int i = 0 ; i<mlist.size();i++) {
			Member m1 = mlist.get(i);
			System.out.println("ȸ�� ���̵� : "+ m1.getMemberId());
			System.out.println("ȸ�� �̸� : "+ m1.getMemberName());
			System.out.println("ȸ�� ���� : "+ m1.getMemberAge());
			System.out.println("==============================");
		
		}
	}

	
	public String inputMemberId() {
		System.out.print("�˻� ���̵� �Է� :");
		return scan.next();
	}
	public String inputMemberName() {
		System.out.print("�˻� �̸� �Է� :");
		return scan.next();
	}
	
	public void displaySuccess(String message) {
		System.out.println("[���� ����]"+message);
	}
	public void displayErro(String message) {
		System.out.println("[���� ����]"+message);
	}
	
	public void ShowopneMember(Member member) {
			System.out.println("ȸ�� ���̵� : "+ member.getMemberId());
			System.out.println("ȸ�� �̸� : "+ member.getMemberName());
			System.out.println("ȸ�� ���� : "+ member.getMemberAge());
		
		
		
	}
	
	public Member changeMember(Member member) {
		
		System.out.println("���̵� : ");
		member.setMemberId(scan.next());
		System.out.println("��й�ȣ : ");
		member.setMemberPwd(scan.next());
		System.out.println("�̸� : ");
		member.setMemberName(scan.next());
		System.out.println("���� : ");
		member.setMemberAge(scan.nextInt());
		System.out.println("���� : ");
		member.setMemberGender(scan.next());
		System.out.println("�̸��� : ");
		member.setMemberEmail(scan.next());
		System.out.println("��ȭ��ȣ : ");
		member.setMemberPhone(scan.next());
		System.out.println("�ּ� : ");
		scan.nextLine();
		member.setMemberAddress(scan.nextLine());
		System.out.println("��� : ");
		member.setMemberHobby(scan.next());

		return member;
		
	}
}
