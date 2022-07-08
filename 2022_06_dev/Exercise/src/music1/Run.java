package music1;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Run {

//		System.out.println("=== 메인 메뉴 ===");
//		System.out.println("1. 마지막 위치에 곡 추가");
//		System.out.println("2. 첫 위치에 곡 추가");
//		System.out.println("3. 전체 곡 목록 출력");
//		System.out.println("4. 특정 곡 검색");
//		System.out.println("5. 특정 곡 삭제");
//		System.out.println("6. 특정 곡 정보 수정");
//		System.out.println("7. 곡명 오름차순 정렬");
//		System.out.println("8. 가수명 내림차순 정렬");
//		System.out.println("0. 종료");
//		System.out.print("메뉴 선택 ==>");

	public static void main(String[] args) {
		MusicView mv = new MusicView();
		Music music = new Music();
		Controller cont = new Controller();
		int sel = 1;
		while (sel != 0) {

			try {
				sel = mv.printMenu();

				switch (sel) {
				case 1:// 마지막곡추가
					music = mv.addSong();
					cont.addSongList(music);
					mv.displaySucess("마지막 곡 추가");
					break;
				case 2:// 처음곡추가
					music = mv.addSong();
					cont.addSongListFist(music);
					mv.displaySucess("처음 곡 추가");
					break;
				case 3:// 전체곡 출력
					List mList = cont.List();
					mv.printAllList(mList);
					break;
				case 4:// 특정곡검색
					String songtitle = mv.inputSong();
					List serchList = cont.serchTitle(songtitle);
					if (serchList.size() == 0) {
						mv.displayFailed("곡 검색");
					}
					mv.displaySucess("곡 검색");
					mv.printAllList(serchList);
					break;
				case 5:// 특정곡 삭제
					songtitle = mv.inputSong();
					serchList = cont.serchTitle(songtitle);
					if (serchList.size() == 0) {
						mv.displayFailed("곡 검색");
					}
					mv.displaySucess("곡 검색");
					Music removeMusic = mv.removList(serchList);
					if (removeMusic==null) {
						mv.displayFailed("곡 삭제");
						break;
					}
					cont.removeMusic(removeMusic);
					mv.displaySucess("삭제");
					break;
				case 6:// 특정 곡 수정
					songtitle = mv.inputSong();
					serchList = cont.serchTitle(songtitle);
					if (serchList.size() == 0) {
						mv.displayFailed("곡 검색");
						break;
					}
					mv.displaySucess("곡 검색");
					Music modifyMusic = mv.modifyMusic(serchList);
					if (modifyMusic==null) {
						mv.displayFailed("곡 수정");
						break;
					}
					int index = cont.modifyMusic(modifyMusic);
					modifyMusic = mv.addSong();
					cont.setList(modifyMusic, index);
					mv.displaySucess("곡 수정");
					break;
				case 7:// 곡명 오름자순
					cont.sort();
					mv.displaySucess("정렬");
					break;
				case 8:// 가수명 내림차순
					cont.disort();
					mv.displaySucess("정렬");
					break;
				case 0:
					break;
				default:
					break;
				}

			} catch (InputMismatchException e) {
				System.out.println("잘못된 입력입니다");
				continue;

			}

		}

	}
}
