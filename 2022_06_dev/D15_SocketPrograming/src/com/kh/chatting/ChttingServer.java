package com.kh.chatting;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChttingServer {
	public static void main(String[] args) {
		ServerSocket serversocket = null;
		int port = 4886;
		InputStream is = null;
		OutputStream os = null;
		Scanner scan = new Scanner(System.in);
		String sendMsg = "";
		String message = "";
		DataInputStream  dis = null;
		DataOutputStream dos = null;

		try {
			System.out.println("서버를 구동중입니다.");
			serversocket = new ServerSocket(port);
			Thread.sleep(1000);
			System.out.println("채팅서버를 구동합니다.");
			Socket socket = serversocket.accept();
			System.out.println("클라이언트를 기다리는 중입니다.");
			Thread.sleep(1000);
			is = socket.getInputStream();
			os = socket.getOutputStream();
			dis = new DataInputStream(is);
			dos = new DataOutputStream(os);
			System.out.println("클라이언트와의 접속이 완료되었습니다");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (true) {
			try {
				
				
				System.out.print("나 : ");
				sendMsg = scan.nextLine();
				dos.writeUTF(sendMsg);
				if(sendMsg.equals("exit")) {
					break;
				}
				
				message = dis.readUTF();
				System.out.println("상대 : " + message);
				
				if( message.equals("exit")) {
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("채팅을 종료합니다");
	}
}
