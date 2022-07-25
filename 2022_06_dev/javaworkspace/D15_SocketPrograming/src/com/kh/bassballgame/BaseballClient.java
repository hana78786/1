package com.kh.bassballgame;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class BaseballClient {
//	클라이언트 소켓을 생성했습니다.
//	게임 준비 완료
//	--> 1 2 3
//	0 스트라이크 2 볼
//	--> 2 3 9
//	1 스트라이크 0 볼
//	--> 2 8 7
//	1 스트라이크 0 볼
//	--> 2 3 1
//	2 스트라이크 0 볼
//	--> 2 3 7
//	1 스트라이크 0 볼
//	--> 2 4 1
//	3 스트라이크 0 볼
	public static void main(String[] args) {
		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;
		DataOutputStream dos = null;
		DataInputStream dis = null;
		String address = "127.0.0.1";
		int port = 8889;
		String game = "";
		Scanner scan = new Scanner(System.in);
		String result = "";
		//여기까지는 필요한 변수 선언 및 자바에서 필요한거 가져오는거
		
		

		try {
			socket = new Socket(address, port);
			System.out.println("소켓을 생성했습니다.");
			Thread.sleep(1000);
			is = socket.getInputStream();
			os = socket.getOutputStream();
			dis = new DataInputStream(is);
			dos = new DataOutputStream(os);
			System.out.println("게임 준비 완료");
			Thread.sleep(1000);
		////////여기까지는 소켓연결~~~	
		

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (true) {
			try {

			//여기는 게임 번호 입력하기
				System.out.print("--->");
				game = scan.nextLine();
				dos.writeUTF(game);
			//..........................
				
				result = dis.readUTF(); //서버에서 받아온 문자!
				
				//서버에서 입력오류처리시 입력으로 돌아가는 코드
				if(result.equals("입력오류!")) {
					System.out.println(result);
					continue;
				}
				//....................
				
				//게임에서 승리시 서버에서 승리 코드 가져와서 승리 선언하는 코드
				if (result.equals("end")) {
					System.out.println("승리하셨습니다!!!");
					break;
				}
				// ..........
				
				
				System.out.println(result);// 서버에서 보내준 게임 결과 값 출력

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//게임 종료메세지
		System.out.println("게임을 종료합니다.");
	}
}
