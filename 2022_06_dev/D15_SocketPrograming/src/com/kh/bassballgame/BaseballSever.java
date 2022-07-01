package com.kh.bassballgame;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.StringTokenizer;

public class BaseballSever {
//	���������� �����Ͽ����ϴ�.
//	Ŭ���̾�Ʈ�� ������ ��ٸ��ϴ�...
//	Ŭ���̾�Ʈ�� �����߽��ϴ�.
//	���� ���� -> 2 4 1
//	���� �غ� �Ϸ�
//	Ŭ���̾�Ʈ�� �Է��� �� -> 1 2 3
//	0 ��Ʈ����ũ 2 ��
//	Ŭ���̾�Ʈ�� �Է��� �� -> 2 3 9
//	1 ��Ʈ����ũ 0 ��
//	Ŭ���̾�Ʈ�� �Է��� �� -> 2 8 7
//	1 ��Ʈ����ũ 0 ��
//	Ŭ���̾�Ʈ�� �Է��� �� -> 2 3 1
//	2 ��Ʈ����ũ 0 ��
//	Ŭ���̾�Ʈ�� �Է��� �� -> 2 3 7
//	1 ��Ʈ����ũ 0 ��
//	Ŭ���̾�Ʈ�� �Է��� �� -> 2 4 1
//	3 ��Ʈ����ũ 0 ��
//	�ƿ�! ��������!

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		int port = 8889;
		InputStream is = null;
		OutputStream os = null;
		DataOutputStream dos = null;
		DataInputStream dis = null;
		String game = "";
		String result = "";
		///�ʿ��� ���� ���� �� ���� �������� ��Ʈ�� ����
		

		try {
			System.out.println("���������� �����Ͽ����ϴ�.");
			Thread.sleep(1000);
			serverSocket = new ServerSocket(port);
			System.out.println("Ŭ���̾��� ������ ��ٸ��ϴ�");
			Thread.sleep(1000);
			Socket socket = serverSocket.accept();
			System.out.println("Ŭ���̾�Ʈ�� �����߽��ϴ�.");
			Thread.sleep(1000);
			is = socket.getInputStream();
			os = socket.getOutputStream();
			dos = new DataOutputStream(os);
			dis = new DataInputStream(is);
			//////////��������� ���Ͽ��� �ϴ� �ڵ�
			
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			///�������� �迭�����
			Random random = new Random();
			int[] gameNum = new int[3];

			/// ���� ��ġ�� �ʰ�///
			for (int i = 0; i < 3; i++) {
				gameNum[i] = random.nextInt(9) + 1;
				for (int j = 0; j < i; j++) {
					if (gameNum[i] == gameNum[j]) {
						i--;
					}
				}
			}
			//.............................
			
			//��������� �ڵ� ���
			System.out.println("�������� " + gameNum[0] + " " + gameNum[1] + " " + gameNum[2]);

			int Strike = 0;
			int ball = 0;
			//���� ����
			
			while (true) {
				//Ŭ���̾�Ʈ�� ���� ���ڸ� �޾Ƽ� ������ �ڵ�
				game = dis.readUTF();
				StringTokenizer st = new StringTokenizer(game, " ");
				//.................................
				
				////����� �Է¿����� �ݺ��ϴ� �ڵ�///
				if (st.countTokens() != 3) {
					result = "�Է¿���!";
					dos.writeUTF(result);//�������� result���� ������ߵ�!
					continue;
				}
				/////////..........................
				
				////Ŭ���̾�Ʈ�� �Է��� ���ڸ� �迭�� ����� �ڵ�////
				int inGame[] = new int[3];
				inGame[0] = Integer.parseInt(st.nextToken());
				inGame[1] = Integer.parseInt(st.nextToken());
				inGame[2] = Integer.parseInt(st.nextToken());
				System.out.println("Ŭ���̾�Ʈ�� �Է��� �� : " + inGame[0] + " " + inGame[1] + " " + inGame[2]);
				////////.............................
				
				////������ ������ ���ڿ� Ŭ���̾�Ʈ�� ���ڸ� ���Ͽ� ���� �ִ� �ڵ�////
				for (int i = 0; i < 3; i++) {
					if (inGame[i] == gameNum[i]) {
						Strike++;
					}
					for (int j = 0; j < 3; j++) {
						if (i != j && inGame[i] == gameNum[j]) {
							ball++;
						}
					}
				}
				//////////
				
				/// ��½� �����ϴ� �ڵ�/////
				if (Strike == 3) {
					result = "end";
					dos.writeUTF(result);//�� �� �����ִ°� ������ �ȵ�!
					break;
				}
				///////////////////
				

				/////������ ����ϴ� �ڵ�...../////
				result = Strike + " ��Ÿ����ũ  / " + ball + " ��";
				dos.writeUTF(result);
				///////////////////////////
				
				//������ �ʱ�ȭ�Ͽ� �ٽóѰ��ִ� �ڵ�////
				Strike = 0;
				ball = 0;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		System.out.println("�ƿ� ��������!");

	}
}
