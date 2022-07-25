package music;

import java.util.List;
import java.util.Scanner;

public class MusicView {
	Music music = new Music();

	public int printMenu(Scanner scan) {

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

	
	public Music plusSong(Scanner scan) {
		Music music = new Music();
		System.out.println("추가할 곡을 입력하세요");
		
		System.out.print("곡 명 :");
		scan.nextLine();
		music.setSongTitle(scan.nextLine());
		System.out.print("가수 명 :");
		music.setSinger(scan.next());
		
		return music;
	}


	public void printAllList(List<Music> mList) {
		// TODO Auto-generated method stub
		for(int i=0; i<mList.size();i++) {
		music = mList.get(i);
		System.out.println((i+1)+"번째 곡");
		System.out.println("제목 "+music.getSongTitle());
		System.out.println("가수 "+music.getSinger());
		System.out.println("=-=-=-=-=-=-=-=-=-=-=");
		}
		
		
	}


	public String serchSong(Scanner scan) {
		scan.nextLine();
		// TODO Auto-generated method stub
		System.out.println("검색할 곡명을 입력하세요");
		System.out.print("곡명 : ");
		String SongTilte = scan.nextLine();
		
		return SongTilte;
		
	}


	public void printSerchSong(Music music2) {
		// TODO Auto-generated method stub
		System.out.println("검색하신 곡은 : "+music2.getSongTitle());
		System.out.println("검색하신 곡의 가수는 : "+music2.getSinger());
		
	}


	public void displayErorr(String message) {
		// TODO Auto-generated method stub
		System.out.println(message+"오류");
		
	}


	public void displaySucess(String message) {
		// TODO Auto-generated method stub
		System.out.println(message+"성공");
		
	}


	public Music changeSongInfo(Music music2, Scanner scan) {
		// TODO Auto-generated method stub
		System.out.println("곡의 정보를 교체합니다");
		System.out.print("바꿀 곡 명 : ");
		music2.setSongTitle(scan.nextLine());
		System.out.print("가수 명 : ");
		music2.setSinger(scan.next());

		return music2;
	}
}
