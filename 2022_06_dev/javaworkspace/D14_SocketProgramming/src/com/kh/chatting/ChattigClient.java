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
//		서버에 연결중입니다.
//		채팅서버에 접속하였습니다.
//		서버와의 채팅을 시작합니다.
//		서버(상대) : 하이
//		클라이언트(나) : 네네

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
			System.out.println("서버에 연결중입니다.");
			Thread.sleep(2000);
			socket = new Socket(adress, port);
			os = socket.getOutputStream();
			is = socket.getInputStream();

			System.out.println("채팅서버에 접속하였습니다.");
			Thread.sleep(2000);

			/// 데이터 보내기///

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
				////////////////////읽기
				bytes = new byte[100];
				int readByte = is.read(bytes);
				message = new String(bytes, 0, readByte);
				System.out.println("서버(상대) : " + message);
				////////////////쓰기
				System.out.print("클라이언트(나) : ");
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
