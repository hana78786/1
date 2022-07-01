package com.kh.chatting;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ChattingClient {
	public static void main(String[] args) {
		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;
		int port = 4886;
		String address = "127.0.0.1";
		String message = "";
		String sendMsg = "";
		Scanner scan = new Scanner(System.in);
		DataInputStream dis = null;
		DataOutputStream dos = null;
		int readbyte;

		try {
			System.out.println("서버와 연결합니다..");
			Thread.sleep(1000);
			socket = new Socket(address, port);
			System.out.println("서버와 연결되었습니다.");
			Thread.sleep(1000);
			is = socket.getInputStream();
			os = socket.getOutputStream();
			dis = new DataInputStream(is);
			dos = new DataOutputStream(os);
			System.out.println("채팅을 시작합니다.");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while (true) {
			try {
				
				message = dis.readUTF();
				System.out.println("상대 : " + message);
				if(message.equals("exit")) {
					break;
				}
				System.out.print("나 : ");
				sendMsg = scan.nextLine();
				dos.writeUTF(sendMsg);
				
				if(sendMsg.equals("exit")) {
					break;
				}
				
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}System.out.println("채팅을 종료합니다.");
}}
