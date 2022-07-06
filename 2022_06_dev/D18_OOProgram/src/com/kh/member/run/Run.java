package com.kh.member.run;

import java.util.ArrayList;

import com.kh.member.controller.Controller;
import com.kh.member.model.vo.Member;
import com.kh.memeber.view.MemberView;

//����Ŭ����
public class Run {
	public static void main(String[] args) {
		MemberView mv = new MemberView();
		Controller controller = new Controller();
		Member member = null;

		done: while (true) {

			int choice = mv.mainMenu(); // �� �ڵ�� ���θ޴�ȣ��!

			switch (choice) {
			case 1:
				System.out.println("ȸ������ ��ȸ");
				ArrayList<Member> mList = controller.printAllMember();
				mv.printAllMember(mList);
				break;
			case 2:
				System.out.println("ȸ�� ���̵�� ��ȸ");
				String memberId = mv.inputMemberId();
				int index = controller.findMeberId(memberId);
				if (index == -1) {
					mv.displayErro("ȸ�� ��ȸ ����");
				} else {
					member = controller.pirntOneById(index);
					mv.ShowopneMember(member);
				}
				break;
			case 3:
				System.out.println("ȸ�� �̸����� ��ȸ");
				String memberName = mv.inputMemberName();
				index = controller.findMeberName(memberName);
				if (index == -1) {
					mv.displayErro("ȸ�� ��ȸ ����");
				} else {
					member = controller.pirntOneById(index);
					mv.ShowopneMember(member);
					
				}
				break;
			case 4:
				System.out.println("ȸ������");
				member = mv.inputMember();
				controller.registerMember(member);
				break;
			case 5:
				System.out.println("ȸ�� ���� ����");
				
				System.out.println("ȸ�� ���̵�� ��ȸ");
				memberId = mv.inputMemberId();
				index = controller.findMeberId(memberId);
				if (index == -1) {
					mv.displayErro("ȸ�� ��ȸ ����");
					break;
				} else {
					member = controller.pirntOneById(index);
					mv.ShowopneMember(member);
				}
				mv.changeMember(member);
				
				
				
				
				
				
				
				
				break;
			case 6:
				memberId = mv.inputMemberId();
				index = controller.findMeberId(memberId);
				if (index == -1) {
					mv.displayErro("ȸ�� ��ȸ ����");
				} else {
					controller.removeMember(index);
					mv.displaySuccess("ȸ�� Ż�� �Ϸ�");
				}
				break;
			case 0:
				System.out.println("���α׷�����");
				break done;
			default:
				System.out.println("�߸��� �Է��Դϴ�.");
				break;
			}
		}

	}

}
