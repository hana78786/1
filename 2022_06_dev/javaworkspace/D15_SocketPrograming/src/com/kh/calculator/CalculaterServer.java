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
			System.out.println("������ ��ٸ��� �ֽ��ϴ�....");
			Thread.sleep(1000);
			severSocket = new ServerSocket(port);
			System.out.println("����Ǿ����ϴ�");
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
					//bye�Է½� ��������, equalsIgnoreCase�� ��ҹ��� �������� ����
					System.out.println("������ �����մϴ�.");
					break;
				}

				StringTokenizer st = new StringTokenizer(calcul, " ");
				//���ڸ� (a,b)b�� �������� �����ش�.
				
				
				if (st.countTokens() != 3) {
					//b�� �������� ���� ���ڰ� ����� �Ǵ��Ѵ�	
					//3���� �ƴҶ� �����޼��� 
			
					System.out.println("�߸��Է��ϼ̽��ϴ�");
					dos.writeUTF("�ٽ� �Է����ּ���");
					continue; //while������ ���ư���
				}
				
				
				int a = Integer.parseInt(st.nextToken()); 
				String oper = st.nextToken(); 
				int b = Integer.parseInt(st.nextToken());
				//st.nextToken()�� ���ڰ� �ʿ���� �ڸ� ������� �����ϸ� �����ش�
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
//					result = "�߸����Է��Դϴ�";
//				}
				dos.writeUTF(result);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("�����մϴ�");
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
