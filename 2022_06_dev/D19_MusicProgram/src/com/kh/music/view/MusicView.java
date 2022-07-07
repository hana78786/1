package com.kh.music.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.music.model.vo.Music;

public class MusicView {

	public int printMenu() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("=== 메인 메뉴 ===");
		System.out.println("1. 마지막 위치에 곡 추가");
		System.out.println("2. 첫 위치에 곡 추가");
		System.out.println("3. 전체 곡 목록 출력");
		System.out.println("4. 특정 곡 검색");
		System.out.println("5. 특정 곡 삭제");
		System.out.println("6. 특정 곡 정보 수정");
		System.out.println("7. 곡명 오름차순 정렬");
		System.out.println("8. 가수명 내림차순 정렬");
		System.out.println("0. 종료");
		System.out.print("메뉴 선택 ==>");
		int sel = scan.nextInt();
		
		return sel;

	}

	public Music addSong() {
		Scanner scan = new Scanner(System.in);
		Music music = new Music();
		System.out.print("곡 명을 입력하세요 : ");
		music.setMusic(scan.nextLine());
		System.out.print("가수 명을 입력하세요 :");
		music.setSinger(scan.next());
		
		System.out.println("입력이 완료되었습니다");
		return music;
		
	}

	public void printList(ArrayList<Music> mList) {
		// TODO Auto-generated method stub
		System.out.println("현재 입력된 곡은 "+mList.size()+"곡 입니다");
		for(int i =0; i<mList.size();i++) {
			Music music = mList.get(i);
			System.out.println((i+1)+"번째"+music);
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		}
		
	}

	public String serchSong() {
		Scanner scan = new Scanner(System.in);
		System.out.print("찾으시는 곡 명을 입력하세요 :");
		String songName = scan.nextLine();
		
		return songName;
		
		
	}

	public void printSerchSong(Music serchSong) {
		// TODO Auto-generated method stub
		System.out.print("검색하신 ");
		System.out.println(serchSong.toString());
		
	}

	public Music musicChangeInfo(Music changeSong) {
		Scanner scan = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.println("곡을 변경합니다");
		System.out.println("변경할 내용을 입력해주세요");
		System.out.print("곡 명 :");
		changeSong.setMusic(scan.nextLine());
		System.out.print("가수 명 : ");
		changeSong.setSinger(scan.next());
		
		return changeSong;
	}
	
	public void displaySucess(String message) {
		// TODO Auto-generated method stub
		System.out.println(message+"성공!");
	}
	public void displayErorr(String message) {
		// TODO Auto-generated method stub
	System.out.println(message+"실패!");
	}

}
