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
				
				case 1:System.out.println("������ ��ġ�� �� �߰�");
				music =mv.plusSong(scan);
				cont.addSongList(music);				
					break;
					
				case 2:System.out.println("ó�� �� �߰�");
				music = mv.plusSong(scan);
				cont.addSongListFirst(music);	
					break;
					
				case 3:System.out.println("��ü �� ���");
				List<Music>mList = cont.allList();
				mv.printAllList(mList);
					break;
					
				case 4:System.out.println("������� �˻�");
				String SongTilte = mv.serchSong(scan);
				int index = cont.serchTitle(SongTilte);
				if(index==-1) {
					mv.displayErorr("�˻�");
					break;
				}
				music = cont.SongListIndex(index);
				mv.printSerchSong(music);				
					break;
					
					
				case 5:System.out.println("�� ����");
				SongTilte = mv.serchSong(scan);
				index = cont.serchTitle(SongTilte);
				if(index==-1) {
					mv.displayErorr("�˻�");
					break;
				}
				cont.songRemove(index);
					mv.displaySucess("����");				
					break;
					
					
				case 6:System.out.println("�� ���� ����");
				SongTilte = mv.serchSong(scan);
				index = cont.serchTitle(SongTilte);
				if(index==-1) {
					mv.displayErorr("�˻�");
					break;
				}
				music = cont.SongListIndex(index);
				Music musicCh=mv.changeSongInfo(music, scan);
				cont.ChangeInfo(musicCh, index);
				mv.displaySucess("��������");
					break;
					
					
				case 7:System.out.println("�� �� �������� ����");
					break;
				case 8:System.out.println("���� �� �������� ����");
					break;
				case 0:System.out.println("���α׷��� ���� �մϴ�");
					break;
				default:System.out.println("�ٽ� �Է��ϼ���");
					break;
				}

			} catch (InputMismatchException e) {
				System.out.println("�߸��� �Է��Դϴ�");
				continue;
			}
		}
	}
}
