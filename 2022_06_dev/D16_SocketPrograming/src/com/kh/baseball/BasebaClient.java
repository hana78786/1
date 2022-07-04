package com.kh.baseball;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BasebaClient {
	public static void main(String[] args) {
		Socket socket = null;
		String address = "127.0.0.1";
		int port = 8889;
		InputStream is = null;
		OutputStream os = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		Scanner scan = new Scanner(System.in);
		String answer = "";
	        
		try {
			System.out.println("������ �����ϴ� ���Դϴ�.");
			socket = new Socket(address, port);
			System.out.println("�������� ������ �Ϸ�Ǿ����ϴ�");
			is = socket.getInputStream();
			os = socket.getOutputStream();
			dos = new DataOutputStream(os);
			dis = new DataInputStream(is);
			System.out.println("���� �غ� �Ϸ�");

			for (;;) {// �ݺ��� ����
				System.out.print("-->");// ���������Ʈ
				answer = scan.nextLine();// �Է¹ޱ�
				dos.writeUTF(answer);// ���� �Է� ���� ����
				answer = dis.readUTF();// ������ ���� ���ھ� ����

				if (answer.equals("����")) {
					System.out.println("10�̸��� ���ڸ� 3�� ����� �����ؼ� �Է��ϼ���");
					continue;
				}

				System.out.println(answer);// ���Ź��� ���ھ� ���
				if (answer.equals("��Ʈ����ũ 3")) {// ���ھ� ��ũ����ũ 3�϶�
					System.out.println("�¸��ϼ̽��ϴ�");// �¸� �޼��� ���
					break;// ����
				}

			}
			
			System.out.println("�������� ������ �����մϴ�");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
