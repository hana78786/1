package music1;

import java.util.List;
import java.util.Scanner;

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
		System.out.println("=-=-=-=곡을 입력합니다=-=-=-=");
		System.out.print("타이틀 명 : ");
		music.setSongTilte(scan.nextLine());
		System.out.print("가수 명 : ");
		music.setSinger(scan.next());

		return music;
	}

	public void displaySucess(String string) {
		// TODO Auto-generated method stub

		System.out.println(string + "성공!");

	}

	public void displayFailed(String string) {
		// TODO Auto-generated method stub

		System.out.println(string + "실패!");

	}

	public void printAllList(List mList) {
		// TODO Auto-generated method stub
		for (int i = 0; i < mList.size(); i++) {
			Music music = (Music) mList.get(i);
			System.out.println("=-=-=-=-"+(i+1)+"번째=-=-=-=-");
			System.out.println("곡의 제목 : "+music.getSongTilte());
			System.out.println("번째 곡의 가수 : "+music.getSinger());
		}

	}

	public String inputSong() {
		Scanner scan = new Scanner(System.in);
		System.out.println("검색할 곡 명을 입력하세요");
		System.out.print("제목 : ");
		String SongTitle = scan.nextLine();
		
		return SongTitle;
	}

	public Music removList(List serchList) {
		Scanner scan = new Scanner(System.in);
		int i=0;
		for (i = 0; i < serchList.size(); i++) {
			Music music = (Music) serchList.get(i);
			System.out.println("=-=-=-=-"+(i+1)+"번째=-=-=-=-");
			System.out.println("곡의 제목 : "+music.getSongTilte());
			System.out.println("번째 곡의 가수 : "+music.getSinger());
		}
		System.out.println("삭제할 곡 번호를 입력해주세요");
		System.out.print("번호 : ");
		int index = scan.nextInt()-1;
		if(index<0||index>serchList.size()-1) {
			return null;
		}else{
		Music music = (Music) serchList.get(index);
		
		return music;}
		
		
	}

	public Music modifyMusic(List serchList) {
		Scanner scan = new Scanner(System.in);
		int i=0;
		for (i = 0; i < serchList.size(); i++) {
			Music music = (Music) serchList.get(i);
			System.out.println("=-=-=-=-"+(i+1)+"번째=-=-=-=-");
			System.out.println("곡의 제목 : "+music.getSongTilte());
			System.out.println("번째 곡의 가수 : "+music.getSinger());
		}
		System.out.println("수정할 곡 번호를 입력해주세요");
		System.out.print("번호 : ");
		int index = scan.nextInt()-1;
		if(index<0||index>serchList.size()-1) {
			return null;
		}else{
		Music music = (Music) serchList.get(index);
		return music;}
	}


}
