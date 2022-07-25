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
			System.out.println("������ �������Դϴ�.");
			serversocket = new ServerSocket(port);
			Thread.sleep(1000);
			System.out.println("ä�ü����� �����մϴ�.");
			Socket socket = serversocket.accept();
			System.out.println("Ŭ���̾�Ʈ�� ��ٸ��� ���Դϴ�.");
			Thread.sleep(1000);
			is = socket.getInputStream();
			os = socket.getOutputStream();
			dis = new DataInputStream(is);
			dos = new DataOutputStream(os);
			System.out.println("Ŭ���̾�Ʈ���� ������ �Ϸ�Ǿ����ϴ�");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (true) {
			try {
				
				
				System.out.print("�� : ");
				sendMsg = scan.nextLine();
				dos.writeUTF(sendMsg);
				if(sendMsg.equals("exit")) {
					break;
				}
				
				message = dis.readUTF();
				System.out.println("��� : " + message);
				
				if( message.equals("exit")) {
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("ä���� �����մϴ�");
	}
}
