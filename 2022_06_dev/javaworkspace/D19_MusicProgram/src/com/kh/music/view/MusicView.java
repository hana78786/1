package com.kh.music.view;

import java.util.ArrayList;
import java.util.List;
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

	public void printList(List mList) {
		// TODO Auto-generated method stub
		System.out.println("���� �Էµ� ���� "+mList.size()+"�� �Դϴ�");
		for(int i =0; i<mList.size();i++) {
			Music music = (Music) mList.get(i);
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
	public int printSerchAllSong(List<Music> mList) {
		// TODO Auto-generated method stub
		for(int i=0;i<mList.size();i++) {
			System.out.print("�˻��Ͻ� ");
			System.out.println(mList.get(i));
		}
		if(mList.size()==0) {
		return -1;}
		return  0;
		
	}
	public int printSerchAllSongRemove(List selectList) {
		Scanner scan = new Scanner(System.in);
		// TODO Auto-generated method stub
		if(selectList.size()==0) {
			return -1;
		}
		System.out.println(selectList.size());
		System.out.println("�����Ͻ� ���� �����ϼ��� : ");
		for(int i=0;i<selectList.size();i++) {
			System.out.println((i+1)+"�� ");
			System.out.println(selectList.get(i));	
		}
		System.out.println("���� �� �� : ");
		int delInt = scan.nextInt()-1;
		if(delInt+1>selectList.size()||delInt+1<0) return -1;
		
		return delInt;
		
		
	}
	
	

	public Music musicChangeInfo() {
		Scanner scan = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.println("���� �����մϴ�");
		System.out.println("������ ������ �Է����ּ���");
		System.out.print("�� �� :");
		Music musicSong = new Music();
		musicSong.setMusic(scan.nextLine());
		System.out.print("���� �� : ");
		musicSong.setSinger(scan.next());
		
		return musicSong;
	}
	
	public void displaySucess(String message) {
		// TODO Auto-generated method stub
		System.out.println(message+"����!");
	}
	public void displayErorr(String message) {
		// TODO Auto-generated method stub
	System.out.println(message+"����!");
	}

	public void pirntMessage(String message) {
		// TODO Auto-generated method stub
		System.out.println("=-=-=-=-=-=-=-="+message+"-=-=-=-=-=-=");
		
	}

	public int printSerchAllSongChange(List selectList) {
		Scanner scan = new Scanner(System.in);
		// TODO Auto-generated method stub
		if(selectList.size()==0) {
			return -1;
		}
		System.out.println("���� �����ϼ��� : ");
		for(int i=0;i<selectList.size();i++) {
			System.out.println((i+1)+"�� ");
			System.out.println(selectList.get(i));	
		}
		System.out.println("�� ��ȣ : ");
		int delInt = scan.nextInt()-1;
		if(delInt+1>selectList.size()||delInt+1<0) {
			return -1;
		}
		
		return delInt;
		
	}

}
