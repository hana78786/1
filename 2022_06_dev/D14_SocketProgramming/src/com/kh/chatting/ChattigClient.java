package com.kh.chatting;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ChattigClient {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
//		������ �������Դϴ�.
//		ä�ü����� �����Ͽ����ϴ�.
//		�������� ä���� �����մϴ�.
//		����(���) : ����
//		Ŭ���̾�Ʈ(��) : �׳�

		Socket socket = null;
		String adress = "127.0.0.1";
		InputStream is = null;
		OutputStream os = null;
		String message = "";
		String sendMsg = "";
		Scanner scan = new Scanner(System.in);
		byte[] bytes = null;

		int port = 8989;
		try {
			System.out.println("������ �������Դϴ�.");
			Thread.sleep(2000);
			socket = new Socket(adress, port);
			os = socket.getOutputStream();
			is = socket.getInputStream();

			System.out.println("ä�ü����� �����Ͽ����ϴ�.");
			Thread.sleep(2000);

			/// ������ ������///

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while (true) {
			try {
				////////////////////�б�
				bytes = new byte[100];
				int readByte = is.read(bytes);
				message = new String(bytes, 0, readByte);
				System.out.println("����(���) : " + message);
				////////////////����
				System.out.print("Ŭ���̾�Ʈ(��) : ");
				sendMsg = scan.nextLine();
				byte[] bytes1 = sendMsg.getBytes();
				os.write(bytes1);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		

			
		}
		
	

	}

}
