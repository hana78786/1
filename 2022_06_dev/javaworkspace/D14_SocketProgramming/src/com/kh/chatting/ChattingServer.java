package com.kh.chatting;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChattingServer {
//	ä�ü����� ���� ���Դϴ�...
//	ä�ü����� �����Ͽ����ϴ�.
//	Ŭ���̾�Ʈ�� ������ ��ٸ��� �ֽ��ϴ�.
//	Ŭ���̾�Ʈ�� �����Ͽ����ϴ�.
//	ä���� ���۵Ǿ����ϴ�.
//	����(��) : ����
//	Ŭ���̾�Ʈ(���) : �׳�

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		int port = 8989;
		InputStream is = null;
		OutputStream os = null;
		String sendMsg = "";
		byte[] bytes1 =null;
		String message ="";

		try {

			System.out.println("ä�ü����� �������Դϴ�.......");
			Thread.sleep(2000); // �ð����� 2h
			serverSocket = new ServerSocket(port);
			System.out.println("ä�ü����� �����Ͽ����ϴ�.");
			Thread.sleep(2000);
			System.out.println("Ŭ���̾�Ʈ�� ������ ��ٸ��� �ֽ��ϴ�.");
			Thread.sleep(2000);
			Socket socket = serverSocket.accept();
			System.out.println("Ŭ���̾�Ʈ�� �����Ͽ����ϴ�.");
			is = socket.getInputStream();
			os = socket.getOutputStream();
			System.out.println("ä���� �����Ͽ����ϴ�");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Scanner scan = new Scanner(System.in);
		while (true) {
			try {
				//////////////////����
				System.out.print("����(��) : ");
				sendMsg = scan.nextLine();
				byte[] bytes = sendMsg.getBytes();
				os.write(bytes);
				//////////////////�б�
				bytes1 = new byte[100];
				int readByte = is.read(bytes1);
				message = new String(bytes1, 0, readByte);
				System.out.println("Ŭ���̾�Ʈ(���) : " + message);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		

		}
	}

}
