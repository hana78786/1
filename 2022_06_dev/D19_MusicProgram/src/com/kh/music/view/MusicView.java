package com.kh.music.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.music.model.vo.Music;

public class MusicView {

	public int printMenu() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("=== ���� �޴� ===");
		System.out.println("1. ������ ��ġ�� �� �߰�");
		System.out.println("2. ù ��ġ�� �� �߰�");
		System.out.println("3. ��ü �� ��� ���");
		System.out.println("4. Ư�� �� �˻�");
		System.out.println("5. Ư�� �� ����");
		System.out.println("6. Ư�� �� ���� ����");
		System.out.println("7. ��� �������� ����");
		System.out.println("8. ������ �������� ����");
		System.out.println("0. ����");
		System.out.print("�޴� ���� ==>");
		int sel = scan.nextInt();
		
		return sel;

	}

	public Music addSong() {
		Scanner scan = new Scanner(System.in);
		Music music = new Music();
		System.out.print("�� ���� �Է��ϼ��� : ");
		music.setMusic(scan.nextLine());
		System.out.print("���� ���� �Է��ϼ��� :");
		music.setSinger(scan.next());
		
		System.out.println("�Է��� �Ϸ�Ǿ����ϴ�");
		return music;
		
	}

	public void printList(ArrayList<Music> mList) {
		// TODO Auto-generated method stub
		System.out.println("���� �Էµ� ���� "+mList.size()+"�� �Դϴ�");
		for(int i =0; i<mList.size();i++) {
			Music music = mList.get(i);
			System.out.println((i+1)+"��°"+music);
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		}
		
	}

	public String serchSong() {
		Scanner scan = new Scanner(System.in);
		System.out.print("ã���ô� �� ���� �Է��ϼ��� :");
		String songName = scan.nextLine();
		
		return songName;
		
		
	}

	public void printSerchSong(Music serchSong) {
		// TODO Auto-generated method stub
		System.out.print("�˻��Ͻ� ");
		System.out.println(serchSong.toString());
		
	}

	public Music musicChangeInfo(Music changeSong) {
		Scanner scan = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.println("���� �����մϴ�");
		System.out.println("������ ������ �Է����ּ���");
		System.out.print("�� �� :");
		changeSong.setMusic(scan.nextLine());
		System.out.print("���� �� : ");
		changeSong.setSinger(scan.next());
		
		return changeSong;
	}
	
	public void displaySucess(String message) {
		// TODO Auto-generated method stub
		System.out.println(message+"����!");
	}
	public void displayErorr(String message) {
		// TODO Auto-generated method stub
	System.out.println(message+"����!");
	}

}
