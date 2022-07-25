package com.kh.baseball;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class BasevallSever {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		int port = 8889;
		InputStream is = null;
		OutputStream os = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		int[] goals = new int[3];
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		String answer = "";
		DateFormat formatter = new SimpleDateFormat("[hh:mm:ss a]");
		String time = formatter.format(new Date());

		try {
			System.out.println("서버를 연결합니다");
			serverSocket = new ServerSocket(port);
			System.out.println("클라이언트를 기다리는 중입니다");
			Socket socket = serverSocket.accept();
			System.out.println(time + " 클라이언트와 접속이 완료되었습니다");
			is = socket.getInputStream();
			os = socket.getOutputStream();
			dos = new DataOutputStream(os);
			dis = new DataInputStream(is);
			System.out.println("서버 준비 완료");

			for (int i = 0; i < 3; i++) {
				goals[i] = random.nextInt(8) + 1;
				for (int j = 0; j < i; j++) {
					if (goals[i] == goals[j]) {
						i--;
					}
				}
			}

			sb.append(goals[0]).append(" ").append(goals[1]).append(" ").append(goals[2]);
			System.out.println("서버숫자:" + sb);
			System.out.println("서버준비 완료");

			for (;;) {
				int strike = 0;
				int ball = 0;
				// 서버의 게임 받기//
				System.out.println("=-=-=-=-=-=-=-=-");
				answer = dis.readUTF();
				System.out.println("클라이언트가 입력한수 : " + answer);
				String[] nums = answer.split(" ");// 클라이언트의 숫자를 공백을 기준으로 배열로 만든다

				if (nums.length != 3) {// 클라이언트가 입력오류를 일으켰을때
					dos.writeUTF("오류");
					continue;

				}

				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						int num = Integer.parseInt(nums[j]);
						//// 형변환해주었음////
						if (goals[i] == num) {
							if (i == j) {
								strike++;
							} else {
								ball++;
							}
						}
					}
				}
				// 점수계산 끝

				// 점수를 클라이언트로 전송///
				if (strike == 3) {// 스트라이크 3이 나왔을때 게임 종료
					dos.writeUTF("스트라이크 3");
					String time1 = formatter.format(new Date());
					System.out.println(time1 + " 게임오버!");
					break;
				}

				// 클라이언트에게 보낼 스코어 메세지
				String SeverAns = "스트라이크 : " + strike + ", 볼 : " + ball;
				System.out.println(SeverAns);// 메세지 프린트
				dos.writeUTF(SeverAns);// 메세지 전송

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
