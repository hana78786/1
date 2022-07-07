package com.kh.music.run;

import java.util.ArrayList;
import java.util.InputMismatchException;

import com.kh.music.controller.Controller;
import com.kh.music.model.vo.Music;
import com.kh.music.view.MusicView;

public class Run {
//	=== ���� �޴� ===
//	1. ������ ��ġ�� �� �߰�
//	2. ù ��ġ�� �� �߰�
//	3. ��ü �� ��� ���
//	4. Ư�� �� �˻�
//	5. Ư�� �� ����
//	6. Ư�� �� ���� ����
//	7. ��� �������� ����
//	8. ������ �������� ����
//	0. ����
//	�޴� ���� ==>

	public static void main(String[] args) {
		MusicView mv = new MusicView();
		Controller cont = new Controller();
		int sel = 1;
		while (sel != 0) {
			try {
				sel = mv.printMenu();
				switch (sel) {
				case 1:
					System.out.println("������ ��ġ�� ���� �߰��մϴ�");
					Music music = mv.addSong();
					cont.addSong(music);
					mv.displaySucess("�� �߰� ");
					break;
				case 2:
					System.out.println("ù ��ġ�� ���� �߰��մϴ�");
					music = mv.addSong();
					cont.addfirstSong(music);
					mv.displaySucess("�� �߰� ");
					break;
				case 3:
					System.out.println("��ü �� ����� ����մϴ�");
					ArrayList<Music> mList = cont.musicList();
					mv.printList(mList);
					break;
				case 4:
					System.out.println("�� ������ �˻��մϴ�");
					// index�� ã��
					String songName = mv.serchSong();
					int index = cont.serchIndex(songName);
					if (index == -1) {
						mv.displayErorr("��� �˻� ");
						break;
					}
					Music serchSong = cont.serchSong(index);
					mv.printSerchSong(serchSong);
					break;
				case 5:
					System.out.println("���� ���� �մϴ�");
					// index�� ã��
					songName = mv.serchSong();
					index = cont.serchIndex(songName);
					if (index == -1) {
						mv.displayErorr("��� �˻� ");
						
						break;
					}
					cont.remove(index);
					mv.displaySucess("�� ���� ");
	
					break;
				case 6:
					System.out.println("�� ������ �˻��մϴ�");
					// index�� ã��
					songName = mv.serchSong();
					index = cont.serchIndex(songName);
					if (index == -1) {
						mv.displayErorr("��� �˻� ");
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
				default:mv.displayErorr("�Է� ");
					break;
				}

			} catch (InputMismatchException e) {
				System.out.println("�߸��� �Է��Դϴ�");
				continue;
			}
		}
	}

}
