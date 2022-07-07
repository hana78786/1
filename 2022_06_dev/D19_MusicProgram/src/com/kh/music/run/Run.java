package com.kh.music.run;

import java.util.ArrayList;
import java.util.InputMismatchException;

import com.kh.music.controller.Controller;
import com.kh.music.model.vo.Music;
import com.kh.music.view.MusicView;

public class Run {
//	=== 메인 메뉴 ===
//	1. 마지막 위치에 곡 추가
//	2. 첫 위치에 곡 추가
//	3. 전체 곡 목록 출력
//	4. 특정 곡 검색
//	5. 특정 곡 삭제
//	6. 특정 곡 정보 수정
//	7. 곡명 오름차순 정렬
//	8. 가수명 내림차순 정렬
//	0. 종료
//	메뉴 선택 ==>

	public static void main(String[] args) {
		MusicView mv = new MusicView();
		Controller cont = new Controller();
		int sel = 1;
		while (sel != 0) {
			try {
				sel = mv.printMenu();
				switch (sel) {
				case 1:
					System.out.println("마지막 위치에 곡을 추가합니다");
					Music music = mv.addSong();
					cont.addSong(music);
					mv.displaySucess("곡 추가 ");
					break;
				case 2:
					System.out.println("첫 위치에 곡을 추가합니다");
					music = mv.addSong();
					cont.addfirstSong(music);
					mv.displaySucess("곡 추가 ");
					break;
				case 3:
					System.out.println("전체 곡 목록을 출력합니다");
					ArrayList<Music> mList = cont.musicList();
					mv.printList(mList);
					break;
				case 4:
					System.out.println("곡 명으로 검색합니다");
					// index값 찾기
					String songName = mv.serchSong();
					int index = cont.serchIndex(songName);
					if (index == -1) {
						mv.displayErorr("곡명 검색 ");
						break;
					}
					Music serchSong = cont.serchSong(index);
					mv.printSerchSong(serchSong);
					break;
				case 5:
					System.out.println("곡을 삭제 합니다");
					// index값 찾기
					songName = mv.serchSong();
					index = cont.serchIndex(songName);
					if (index == -1) {
						mv.displayErorr("곡명 검색 ");
						
						break;
					}
					cont.remove(index);
					mv.displaySucess("곡 삭제 ");
	
					break;
				case 6:
					System.out.println("곡 명으로 검색합니다");
					// index값 찾기
					songName = mv.serchSong();
					index = cont.serchIndex(songName);
					if (index == -1) {
						mv.displayErorr("곡명 검색 ");
						break;
					}
					serchSong = cont.serchSong(index);
					Music changeSong = mv.musicChangeInfo(serchSong);
					cont.setMusic(index, changeSong);
					break;
				case 7:
					cont.sortAscending();
					break;
				case 8:
					break;
				case 0:
					break;
				default:mv.displayErorr("입력 ");
					break;
				}

			} catch (InputMismatchException e) {
				System.out.println("잘못된 입력입니다");
				continue;
			}
		}
	}

}
