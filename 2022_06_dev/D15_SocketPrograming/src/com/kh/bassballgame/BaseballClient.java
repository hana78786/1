package com.kh.bassballgame;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class BaseballClient {
//	Ŭ���̾�Ʈ ������ �����߽��ϴ�.
//	���� �غ� �Ϸ�
//	--> 1 2 3
//	0 ��Ʈ����ũ 2 ��
//	--> 2 3 9
//	1 ��Ʈ����ũ 0 ��
//	--> 2 8 7
//	1 ��Ʈ����ũ 0 ��
//	--> 2 3 1
//	2 ��Ʈ����ũ 0 ��
//	--> 2 3 7
//	1 ��Ʈ����ũ 0 ��
//	--> 2 4 1
//	3 ��Ʈ����ũ 0 ��
	public static void main(String[] args) {
		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;
		DataOutputStream dos = null;
		DataInputStream dis = null;
		String address = "127.0.0.1";
		int port = 8889;
		String game = "";
		Scanner scan = new Scanner(System.in);
		String result = "";
		//��������� �ʿ��� ���� ���� �� �ڹٿ��� �ʿ��Ѱ� �������°�
		
		

		try {
			socket = new Socket(address, port);
			System.out.println("������ �����߽��ϴ�.");
			Thread.sleep(1000);
			is = socket.getInputStream();
			os = socket.getOutputStream();
			dis = new DataInputStream(is);
			dos = new DataOutputStream(os);
			System.out.println("���� �غ� �Ϸ�");
			Thread.sleep(1000);
		////////��������� ���Ͽ���~~~	
		

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (true) {
			try {

			//����� ���� ��ȣ �Է��ϱ�
				System.out.print("--->");
				game = scan.nextLine();
				dos.writeUTF(game);
			//..........................
				
				result = dis.readUTF(); //�������� �޾ƿ� ����!
				
				//�������� �Է¿���ó���� �Է����� ���ư��� �ڵ�
				if(result.equals("�Է¿���!")) {
					System.out.println(result);
					continue;
				}
				//....................
				
				//���ӿ��� �¸��� �������� �¸� �ڵ� �����ͼ� �¸� �����ϴ� �ڵ�
				if (result.equals("end")) {
					System.out.println("�¸��ϼ̽��ϴ�!!!");
					break;
				}
				// ..........
				
				
				System.out.println(result);// �������� ������ ���� ��� �� ���

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//���� ����޼���
		System.out.println("������ �����մϴ�.");
	}
}
