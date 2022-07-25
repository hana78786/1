package com.kh.calculator;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;
import java.util.StringTokenizer;


public class CalculaterClient {
	public static void main(String[] args) {
		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		String calcul = "";
		String result = "";
		int resultInt = 0;
		boolean t_f = true;
		Scanner scan = new Scanner(System.in);

		String address = "127.0.0.1";
		int port = 8999;

		try {
			System.out.println("서버와 연결중입니다.");
			Thread.sleep(1000);
			socket = new Socket(address, port);
			is = socket.getInputStream();
			os = socket.getOutputStream();
			dis = new DataInputStream(is);
			dos = new DataOutputStream(os);

			System.out.println("서버와 연결되었습니다.");
			System.out.println("계산기를 시작합니다.");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while (true) {
			try {
				System.out.print("계산식 (빈칸으로 띄어 입력, 예 24 + 42 >> ");
				calcul = scan.nextLine();
					
				dos.writeUTF(calcul);
				if (calcul.equalsIgnoreCase("bye")) {
					System.out.println("연결을 종료합니다.");
					break;
				}
				if(calcul.equalsIgnoreCase("다시 입력해주세요")) {
					continue;
				}
				result = dis.readUTF();
				System.out.println("계산결과 : " + result);
				

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		
		System.out.println("종료합니다.");
		try {
			dis.close();
			dos.close();
			is.close();
			os.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
