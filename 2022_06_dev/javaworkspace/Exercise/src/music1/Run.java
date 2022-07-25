package music1;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Run {

//		System.out.println("=== ���� �޴� ===");
//		System.out.println("1. ������ ��ġ�� �� �߰�");
//		System.out.println("2. ù ��ġ�� �� �߰�");
//		System.out.println("3. ��ü �� ��� ���");
//		System.out.println("4. Ư�� �� �˻�");
//		System.out.println("5. Ư�� �� ����");
//		System.out.println("6. Ư�� �� ���� ����");
//		System.out.println("7. ��� �������� ����");
//		System.out.println("8. ������ �������� ����");
//		System.out.println("0. ����");
//		System.out.print("�޴� ���� ==>");

	public static void main(String[] args) {
		MusicView mv = new MusicView();
		Music music = new Music();
		Controller cont = new Controller();
		int sel = 1;
		while (sel != 0) {

			try {
				sel = mv.printMenu();

				switch (sel) {
				case 1:// ���������߰�
					music = mv.addSong();
					cont.addSongList(music);
					mv.displaySucess("������ �� �߰�");
					break;
				case 2:// ó�����߰�
					music = mv.addSong();
					cont.addSongListFist(music);
					mv.displaySucess("ó�� �� �߰�");
					break;
				case 3:// ��ü�� ���
					List mList = cont.List();
					mv.printAllList(mList);
					break;
				case 4:// Ư����˻�
					String songtitle = mv.inputSong();
					List serchList = cont.serchTitle(songtitle);
					if (serchList.size() == 0) {
						mv.displayFailed("�� �˻�");
					}
					mv.displaySucess("�� �˻�");
					mv.printAllList(serchList);
					break;
				case 5:// Ư���� ����
					songtitle = mv.inputSong();
					serchList = cont.serchTitle(songtitle);
					if (serchList.size() == 0) {
						mv.displayFailed("�� �˻�");
					}
					mv.displaySucess("�� �˻�");
					Music removeMusic = mv.removList(serchList);
					if (removeMusic==null) {
						mv.displayFailed("�� ����");
						break;
					}
					cont.removeMusic(removeMusic);
					mv.displaySucess("����");
					break;
				case 6:// Ư�� �� ����
					songtitle = mv.inputSong();
					serchList = cont.serchTitle(songtitle);
					if (serchList.size() == 0) {
						mv.displayFailed("�� �˻�");
						break;
					}
					mv.displaySucess("�� �˻�");
					Music modifyMusic = mv.modifyMusic(serchList);
					if (modifyMusic==null) {
						mv.displayFailed("�� ����");
						break;
					}
					int index = cont.modifyMusic(modifyMusic);
					modifyMusic = mv.addSong();
					cont.setList(modifyMusic, index);
					mv.displaySucess("�� ����");
					break;
				case 7:// ��� �����ڼ�
					cont.sort();
					mv.displaySucess("����");
					break;
				case 8:// ������ ��������
					cont.disort();
					mv.displaySucess("����");
					break;
				case 0:
					break;
				default:
					break;
				}

			} catch (InputMismatchException e) {
				System.out.println("�߸��� �Է��Դϴ�");
				continue;

			}

		}

	}
}
