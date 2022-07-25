package com.kh.socket.sample;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerProgram {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;

		try {
			serverSocket = new ServerSocket(4885);
			System.out.println("연결 기다림....");
			Socket socket = serverSocket.accept();
			System.out.println("연결이 수락됨");
			
			
			//// 데이터받기//////////////
			byte[] bytes = null;
			String message = null;
			InputStream is = socket.getInputStream();
			bytes = new byte[100];
			int readByte = is.read(bytes);
			message = new String(bytes,0,readByte);
			System.out.println("데이터받기 성공 : " + message);
			
			
			///////데이터 보내기//////
			OutputStream os = socket.getOutputStream();
			message ="Hello Client";
			bytes = message.getBytes();
			os.write(bytes);
			os.flush();
			System.out.println("데이터 보내기 성공!");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
}
