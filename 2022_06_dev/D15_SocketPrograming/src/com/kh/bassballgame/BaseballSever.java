package com.kh.bassballgame;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.StringTokenizer;

public class BaseballSever {
//	서버소켓을 생성하였습니다.
//	클라이언트의 접속을 기다립니다...
//	클라이언트가 접속했습니다.
//	서버 숫자 -> 2 4 1
//	서버 준비 완료
//	클라이언트가 입력한 수 -> 1 2 3
//	0 스트라이크 2 볼
//	클라이언트가 입력한 수 -> 2 3 9
//	1 스트라이크 0 볼
//	클라이언트가 입력한 수 -> 2 8 7
//	1 스트라이크 0 볼
//	클라이언트가 입력한 수 -> 2 3 1
//	2 스트라이크 0 볼
//	클라이언트가 입력한 수 -> 2 3 7
//	1 스트라이크 0 볼
//	클라이언트가 입력한 수 -> 2 4 1
//	3 스트라이크 0 볼
//	아웃! 게임종료!

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		int port = 8889;
		InputStream is = null;
		OutputStream os = null;
		DataOutputStream dos = null;
		DataInputStream dis = null;
		String game = "";
		String result = "";
		///필요한 변수 선언 및 소켓 서버소켓 스트림 선언
		

		try {
			System.out.println("서버소켓을 생성하였습니다.");
			Thread.sleep(1000);
			serverSocket = new ServerSocket(port);
			System.out.println("클라이언의 접속을 기다립니다");
			Thread.sleep(1000);
			Socket socket = serverSocket.accept();
			System.out.println("클라이언트가 접속했습니다.");
			Thread.sleep(1000);
			is = socket.getInputStream();
			os = socket.getOutputStream();
			dos = new DataOutputStream(os);
			dis = new DataInputStream(is);
			//////////여기까지는 소켓연결 하는 코드
			
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			///랜덤선언 배열만들기
			Random random = new Random();
			int[] gameNum = new int[3];

			/// 랜덤 겹치지 않게///
			for (int i = 0; i < 3; i++) {
				gameNum[i] = random.nextInt(9) + 1;
				for (int j = 0; j < i; j++) {
					if (gameNum[i] == gameNum[j]) {
						i--;
					}
				}
			}
			//.............................
			
			//랜덤출력한 코드 출력
			System.out.println("서버숫자 " + gameNum[0] + " " + gameNum[1] + " " + gameNum[2]);

			int Strike = 0;
			int ball = 0;
			//변수 선언
			
			while (true) {
				//클라이언트가 보낸 숫자를 받아서 나누는 코드
				game = dis.readUTF();
				StringTokenizer st = new StringTokenizer(game, " ");
				//.................................
				
				////여기는 입력오류시 반복하는 코드///
				if (st.countTokens() != 3) {
					result = "입력오류!";
					dos.writeUTF(result);//잊지말고 result값을 보내줘야돼!
					continue;
				}
				/////////..........................
				
				////클라이언트가 입력한 숫자를 배열로 만드는 코드////
				int inGame[] = new int[3];
				inGame[0] = Integer.parseInt(st.nextToken());
				inGame[1] = Integer.parseInt(st.nextToken());
				inGame[2] = Integer.parseInt(st.nextToken());
				System.out.println("클라이언트가 입력한 수 : " + inGame[0] + " " + inGame[1] + " " + inGame[2]);
				////////.............................
				
				////서버가 선별한 숫자와 클라이언트의 숫자를 비교하여 점수 주는 코드////
				for (int i = 0; i < 3; i++) {
					if (inGame[i] == gameNum[i]) {
						Strike++;
					}
					for (int j = 0; j < 3; j++) {
						if (i != j && inGame[i] == gameNum[j]) {
							ball++;
						}
					}
				}
				//////////
				
				/// 우승시 종료하는 코드/////
				if (Strike == 3) {
					result = "end";
					dos.writeUTF(result);//이 값 보내주는거 잊으면 안돼!
					break;
				}
				///////////////////
				

				/////점수를 출력하는 코드...../////
				result = Strike + " 스타라이크  / " + ball + " 볼";
				dos.writeUTF(result);
				///////////////////////////
				
				//점수를 초기화하여 다시넘겨주는 코드////
				Strike = 0;
				ball = 0;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		System.out.println("아웃 게임종료!");

	}
}
