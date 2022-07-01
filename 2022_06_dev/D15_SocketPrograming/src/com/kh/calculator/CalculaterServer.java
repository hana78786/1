package com.kh.calculator;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CalculaterServer {
	public static void main(String[] args) throws SocketException {
		ServerSocket severSocket = null;
		InputStream is = null;
		OutputStream os = null;
		int port = 8999;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		Scanner scan = new Scanner(System.in);
		String calcul = "";
		String result = "";
		try {
			System.out.println("연결을 기다리고 있습니다....");
			Thread.sleep(1000);
			severSocket = new ServerSocket(port);
			System.out.println("연결되었습니다");
			Thread.sleep(1000);
			Socket socket = severSocket.accept();

			is = socket.getInputStream();
			os = socket.getOutputStream();
			dis = new DataInputStream(is);
			dos = new DataOutputStream(os);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while (true) {
			try {
				calcul = dis.readUTF();

				if (calcul.equalsIgnoreCase("bye")) { 
					//bye입력시 연결종료, equalsIgnoreCase는 대소문자 구분하지 않음
					System.out.println("연결을 종료합니다.");
					break;
				}

				StringTokenizer st = new StringTokenizer(calcul, " ");
				//문자를 (a,b)b를 기준으로 나눠준다.
				
				
				if (st.countTokens() != 3) {
					//b를 기준으로 나눈 문자가 몇개인지 판단한다	
					//3개가 아닐때 오류메세지 
			
					System.out.println("잘못입력하셨습니다");
					dos.writeUTF("다시 입력해주세요");
					continue; //while문으로 돌아가기
				}
				
				
				int a = Integer.parseInt(st.nextToken()); 
				String oper = st.nextToken(); 
				int b = Integer.parseInt(st.nextToken());
				//st.nextToken()은 숫자가 필요없다 자른 순서대로 선언하면 나눠준다
				switch (oper) {
				case "+":
					result = (a + b) + "";
					break;
				case "-":
					result = (a - b) + "";
					break;
				case "*":
					result = (a * b) + "";
					break;
				default:
					result = "error";
					break;
				}

//				String[] arrResult = calcul.split(" ");
//				int a = Integer.parseInt(arrResult[0]);
//				int b = Integer.parseInt(arrResult[2]);
//				
//				if (arrResult[1].equals("+")) {
//					resultInt = a + b;
//					t_f = true;
//				} else if (arrResult[1].equals("-")) {
//					resultInt = a - b;
//					t_f = true;
//				} else if (arrResult[1].equals("*")) {
//					resultInt = a * b;
//					t_f = true;
//				} else {
//					t_f = false;
//				}
//
//				if (t_f == true) {
//					result = Integer.toString(resultInt);
//				} else {
//					result = "잘못된입력입니다";
//				}
				dos.writeUTF(result);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("종료합니다");
		try {
			is.close();
			os.close();
			dis.close();
			dos.close();
			scan.close();
			severSocket.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
