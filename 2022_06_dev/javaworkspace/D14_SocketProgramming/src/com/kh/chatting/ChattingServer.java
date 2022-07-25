package com.kh.chatting;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChattingServer {
//	채팅서버를 구동 중입니다...
//	채팅서버를 구동하였습니다.
//	클라이언트의 접속을 기다리고 있습니다.
//	클라이언트가 접속하였습니다.
//	채팅이 시작되었습니다.
//	서버(나) : 하이
//	클라이언트(상대) : 네네

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

			System.out.println("채팅서버를 구동중입니다.......");
			Thread.sleep(2000); // 시간지연 2h
			serverSocket = new ServerSocket(port);
			System.out.println("채팅서버를 구동하였습니다.");
			Thread.sleep(2000);
			System.out.println("클라이언트의 접속을 기다리고 있습니다.");
			Thread.sleep(2000);
			Socket socket = serverSocket.accept();
			System.out.println("클라이언트가 접속하였습니다.");
			is = socket.getInputStream();
			os = socket.getOutputStream();
			System.out.println("채팅이 시작하였습니다");

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
				//////////////////쓰기
				System.out.print("서버(나) : ");
				sendMsg = scan.nextLine();
				byte[] bytes = sendMsg.getBytes();
				os.write(bytes);
				//////////////////읽기
				bytes1 = new byte[100];
				int readByte = is.read(bytes1);
				message = new String(bytes1, 0, readByte);
				System.out.println("클라이언트(상대) : " + message);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		

		}
	}

}
