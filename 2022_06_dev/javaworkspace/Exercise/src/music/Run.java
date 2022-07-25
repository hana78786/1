package music;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		MusicView mv = new MusicView();
		Music music = new Music();
		Controller cont = new Controller();
		int sel = 1;
		while (sel!=0) {
			try {
				Scanner scan = new Scanner(System.in);
				sel = mv.printMenu(scan);
				switch (sel) {
				
				case 1:System.out.println("마지막 위치에 곡 추가");
				music =mv.plusSong(scan);
				cont.addSongList(music);				
					break;
					
				case 2:System.out.println("처음 곡 추가");
				music = mv.plusSong(scan);
				cont.addSongListFirst(music);	
					break;
					
				case 3:System.out.println("전체 곡 출력");
				List<Music>mList = cont.allList();
				mv.printAllList(mList);
					break;
					
				case 4:System.out.println("곡명으로 검색");
				String SongTilte = mv.serchSong(scan);
				int index = cont.serchTitle(SongTilte);
				if(index==-1) {
					mv.displayErorr("검색");
					break;
				}
				music = cont.SongListIndex(index);
				mv.printSerchSong(music);				
					break;
					
					
				case 5:System.out.println("곡 삭제");
				SongTilte = mv.serchSong(scan);
				index = cont.serchTitle(SongTilte);
				if(index==-1) {
					mv.displayErorr("검색");
					break;
				}
				cont.songRemove(index);
					mv.displaySucess("삭제");				
					break;
					
					
				case 6:System.out.println("곡 정보 수정");
				SongTilte = mv.serchSong(scan);
				index = cont.serchTitle(SongTilte);
				if(index==-1) {
					mv.displayErorr("검색");
					break;
				}
				music = cont.SongListIndex(index);
				Music musicCh=mv.changeSongInfo(music, scan);
				cont.ChangeInfo(musicCh, index);
				mv.displaySucess("정보수정");
					break;
					
					
				case 7:System.out.println("곡 명 오름차순 정렬");
					break;
				case 8:System.out.println("가수 명 내림차순 정렬");
					break;
				case 0:System.out.println("프로그램을 종료 합니다");
					break;
				default:System.out.println("다시 입력하세요");
					break;
				}

			} catch (InputMismatchException e) {
				System.out.println("잘못된 입력입니다");
				continue;
			}
		}
	}
}
