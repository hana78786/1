package com.kh.music.run;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

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
					List mList = cont.musicList();
					mv.printList(mList);
					break;
				case 4:
					System.out.println("�� ������ �˻��մϴ�");
					// index�� ã��
					String songName = mv.serchSong();
					mList=cont.selectMusicByname(songName);
					int Sucess = mv.printSerchAllSong(mList);
					if (Sucess == -1) {
						mv.displayErorr("��� �˻� ");
						break;
					}
					int index = cont.serchIndex(songName);//���� �ʿ����
					Music serchSong = cont.serchSong(index);//���� �ʿ����
//					mv.printSerchSong(serchSong);
					break;
				case 5:
					System.out.println("���� ���� �մϴ�");
					// index�� ã��
					songName = mv.serchSong();
					List selectList=cont.selectMusicByname(songName);
					index = mv.printSerchAllSongRemove(selectList);
					if (index == -1) {
						mv.displayErorr("��� �˻� ");
						break;
					}

					cont.remove(index, selectList);
					mv.displaySucess("�� ���� ");
	
					break;
				case 6:
					System.out.println("�� ������ �˻��մϴ�");
					// index�� ã��
					songName = mv.serchSong();
					List selectList1=cont.selectMusicByname(songName);
					index = mv.printSerchAllSongChange(selectList1);
					if (index == -1) {
						mv.displayErorr("��� �˻� ");
						break;
					}
					index = cont.serchIndexChage(index, selectList1);
					Music changeSong = mv.musicChangeInfo();
					cont.setMusic(index, changeSong);
					break;
				case 7:
					mv.pirntMessage("��� ���� ���� ����");
					cont.sortByTitle();
					
					
					
					break;
				case 8:
					mv.pirntMessage("������ ���� ���� ����");
					 cont.sortBySinger() ;
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
