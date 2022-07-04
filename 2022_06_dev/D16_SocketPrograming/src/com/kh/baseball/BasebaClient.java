package com.kh.baseball;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BasebaClient {
	public static void main(String[] args) {
		Socket socket = null;
		String address = "127.0.0.1";
		int port = 8889;
		InputStream is = null;
		OutputStream os = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		Scanner scan = new Scanner(System.in);
		String answer = "";
	        
		try {
			System.out.println("서버와 연결하는 중입니다.");
			socket = new Socket(address, port);
			System.out.println("서버와의 연결이 완료되었습니다");
			is = socket.getInputStream();
			os = socket.getOutputStream();
			dos = new DataOutputStream(os);
			dis = new DataInputStream(is);
			System.out.println("게임 준비 완료");

			for (;;) {// 반복문 시작
				System.out.print("-->");// 출력프롬프트
				answer = scan.nextLine();// 입력받기
				dos.writeUTF(answer);// 받은 입력 서버 전송
				answer = dis.readUTF();// 서버가 보낸 스코어 수신

				if (answer.equals("오류")) {
					System.out.println("10미만의 숫자를 3개 띄어쓰기로 구분해서 입력하세요");
					continue;
				}

				System.out.println(answer);// 수신받은 스코어 출력
				if (answer.equals("스트라이크 3")) {// 스코어 스크라이크 3일때
					System.out.println("승리하셨습니다");// 승리 메세지 출력
					break;// 종료
				}

			}
			
			System.out.println("서버와의 연결을 종료합니다");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
