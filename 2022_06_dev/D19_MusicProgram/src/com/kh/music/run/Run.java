package com.kh.music.run;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

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
					List mList = cont.musicList();
					mv.printList(mList);
					break;
				case 4:
					System.out.println("곡 명으로 검색합니다");
					// index값 찾기
					String songName = mv.serchSong();
					mList=cont.selectMusicByname(songName);
					int Sucess = mv.printSerchAllSong(mList);
					if (Sucess == -1) {
						mv.displayErorr("곡명 검색 ");
						break;
					}
					int index = cont.serchIndex(songName);//현재 필요없음
					Music serchSong = cont.serchSong(index);//현재 필요없음
//					mv.printSerchSong(serchSong);
					break;
				case 5:
					System.out.println("곡을 삭제 합니다");
					// index값 찾기
					songName = mv.serchSong();
					List selectList=cont.selectMusicByname(songName);
					index = mv.printSerchAllSongRemove(selectList);
					if (index == -1) {
						mv.displayErorr("곡명 검색 ");
						break;
					}

					cont.remove(index, selectList);
					mv.displaySucess("곡 삭제 ");
	
					break;
				case 6:
					System.out.println("곡 명으로 검색합니다");
					// index값 찾기
					songName = mv.serchSong();
					List selectList1=cont.selectMusicByname(songName);
					index = mv.printSerchAllSongChange(selectList1);
					if (index == -1) {
						mv.displayErorr("곡명 검색 ");
						break;
					}
					index = cont.serchIndexChage(index, selectList1);
					Music changeSong = mv.musicChangeInfo();
					cont.setMusic(index, changeSong);
					break;
				case 7:
					mv.pirntMessage("곡명 오름 차순 정렬");
					cont.sortByTitle();
					
					
					
					break;
				case 8:
					mv.pirntMessage("가수명 내림 차순 정렬");
					 cont.sortBySinger() ;
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
