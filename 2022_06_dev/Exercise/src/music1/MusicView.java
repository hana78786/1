package music1;

import java.util.List;
import java.util.Scanner;

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
		System.out.println("=-=-=-=���� �Է��մϴ�=-=-=-=");
		System.out.print("Ÿ��Ʋ �� : ");
		music.setSongTilte(scan.nextLine());
		System.out.print("���� �� : ");
		music.setSinger(scan.next());

		return music;
	}

	public void displaySucess(String string) {
		// TODO Auto-generated method stub

		System.out.println(string + "����!");

	}

	public void displayFailed(String string) {
		// TODO Auto-generated method stub

		System.out.println(string + "����!");

	}

	public void printAllList(List mList) {
		// TODO Auto-generated method stub
		for (int i = 0; i < mList.size(); i++) {
			Music music = (Music) mList.get(i);
			System.out.println("=-=-=-=-"+(i+1)+"��°=-=-=-=-");
			System.out.println("���� ���� : "+music.getSongTilte());
			System.out.println("��° ���� ���� : "+music.getSinger());
		}

	}

	public String inputSong() {
		Scanner scan = new Scanner(System.in);
		System.out.println("�˻��� �� ���� �Է��ϼ���");
		System.out.print("���� : ");
		String SongTitle = scan.nextLine();
		
		return SongTitle;
	}

	public Music removList(List serchList) {
		Scanner scan = new Scanner(System.in);
		int i=0;
		for (i = 0; i < serchList.size(); i++) {
			Music music = (Music) serchList.get(i);
			System.out.println("=-=-=-=-"+(i+1)+"��°=-=-=-=-");
			System.out.println("���� ���� : "+music.getSongTilte());
			System.out.println("��° ���� ���� : "+music.getSinger());
		}
		System.out.println("������ �� ��ȣ�� �Է����ּ���");
		System.out.print("��ȣ : ");
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
			System.out.println("=-=-=-=-"+(i+1)+"��°=-=-=-=-");
			System.out.println("���� ���� : "+music.getSongTilte());
			System.out.println("��° ���� ���� : "+music.getSinger());
		}
		System.out.println("������ �� ��ȣ�� �Է����ּ���");
		System.out.print("��ȣ : ");
		int index = scan.nextInt()-1;
		if(index<0||index>serchList.size()-1) {
			return null;
		}else{
		Music music = (Music) serchList.get(index);
		return music;}
	}


}
