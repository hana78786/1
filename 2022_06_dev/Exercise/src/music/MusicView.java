package music;

import java.util.List;
import java.util.Scanner;

public class MusicView {
	Music music = new Music();

	public int printMenu(Scanner scan) {

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

	
	public Music plusSong(Scanner scan) {
		Music music = new Music();
		System.out.println("�߰��� ���� �Է��ϼ���");
		
		System.out.print("�� �� :");
		scan.nextLine();
		music.setSongTitle(scan.nextLine());
		System.out.print("���� �� :");
		music.setSinger(scan.next());
		
		return music;
	}


	public void printAllList(List<Music> mList) {
		// TODO Auto-generated method stub
		for(int i=0; i<mList.size();i++) {
		music = mList.get(i);
		System.out.println((i+1)+"��° ��");
		System.out.println("���� "+music.getSongTitle());
		System.out.println("���� "+music.getSinger());
		System.out.println("=-=-=-=-=-=-=-=-=-=-=");
		}
		
		
	}


	public String serchSong(Scanner scan) {
		scan.nextLine();
		// TODO Auto-generated method stub
		System.out.println("�˻��� ����� �Է��ϼ���");
		System.out.print("��� : ");
		String SongTilte = scan.nextLine();
		
		return SongTilte;
		
	}


	public void printSerchSong(Music music2) {
		// TODO Auto-generated method stub
		System.out.println("�˻��Ͻ� ���� : "+music2.getSongTitle());
		System.out.println("�˻��Ͻ� ���� ������ : "+music2.getSinger());
		
	}


	public void displayErorr(String message) {
		// TODO Auto-generated method stub
		System.out.println(message+"����");
		
	}


	public void displaySucess(String message) {
		// TODO Auto-generated method stub
		System.out.println(message+"����");
		
	}


	public Music changeSongInfo(Music music2, Scanner scan) {
		// TODO Auto-generated method stub
		System.out.println("���� ������ ��ü�մϴ�");
		System.out.print("�ٲ� �� �� : ");
		music2.setSongTitle(scan.nextLine());
		System.out.print("���� �� : ");
		music2.setSinger(scan.next());

		return music2;
	}
}
