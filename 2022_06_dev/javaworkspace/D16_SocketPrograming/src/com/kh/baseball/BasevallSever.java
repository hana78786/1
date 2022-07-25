package com.kh.baseball;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class BasevallSever {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		int port = 8889;
		InputStream is = null;
		OutputStream os = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		int[] goals = new int[3];
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		String answer = "";
		DateFormat formatter = new SimpleDateFormat("[hh:mm:ss a]");
		String time = formatter.format(new Date());

		try {
			System.out.println("������ �����մϴ�");
			serverSocket = new ServerSocket(port);
			System.out.println("Ŭ���̾�Ʈ�� ��ٸ��� ���Դϴ�");
			Socket socket = serverSocket.accept();
			System.out.println(time + " Ŭ���̾�Ʈ�� ������ �Ϸ�Ǿ����ϴ�");
			is = socket.getInputStream();
			os = socket.getOutputStream();
			dos = new DataOutputStream(os);
			dis = new DataInputStream(is);
			System.out.println("���� �غ� �Ϸ�");

			for (int i = 0; i < 3; i++) {
				goals[i] = random.nextInt(8) + 1;
				for (int j = 0; j < i; j++) {
					if (goals[i] == goals[j]) {
						i--;
					}
				}
			}

			sb.append(goals[0]).append(" ").append(goals[1]).append(" ").append(goals[2]);
			System.out.println("��������:" + sb);
			System.out.println("�����غ� �Ϸ�");

			for (;;) {
				int strike = 0;
				int ball = 0;
				// ������ ���� �ޱ�//
				System.out.println("=-=-=-=-=-=-=-=-");
				answer = dis.readUTF();
				System.out.println("Ŭ���̾�Ʈ�� �Է��Ѽ� : " + answer);
				String[] nums = answer.split(" ");// Ŭ���̾�Ʈ�� ���ڸ� ������ �������� �迭�� �����

				if (nums.length != 3) {// Ŭ���̾�Ʈ�� �Է¿����� ����������
					dos.writeUTF("����");
					continue;

				}

				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						int num = Integer.parseInt(nums[j]);
						//// ����ȯ���־���////
						if (goals[i] == num) {
							if (i == j) {
								strike++;
							} else {
								ball++;
							}
						}
					}
				}
				// ������� ��

				// ������ Ŭ���̾�Ʈ�� ����///
				if (strike == 3) {// ��Ʈ����ũ 3�� �������� ���� ����
					dos.writeUTF("��Ʈ����ũ 3");
					String time1 = formatter.format(new Date());
					System.out.println(time1 + " ���ӿ���!");
					break;
				}

				// Ŭ���̾�Ʈ���� ���� ���ھ� �޼���
				String SeverAns = "��Ʈ����ũ : " + strike + ", �� : " + ball;
				System.out.println(SeverAns);// �޼��� ����Ʈ
				dos.writeUTF(SeverAns);// �޼��� ����

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
