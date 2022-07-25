package basballgame;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.StringTokenizer;

public class Server {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		int port = 8889;
		InputStream is = null;
		OutputStream os = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		String gameNum = "";
		String result = "";
		int Strike = 0;
		int ball = 0;

		try {
			System.out.println("서버를 연결합니다.");
			Thread.sleep(1000);
			serverSocket = new ServerSocket(port);
			System.out.println("클라이언트와의 연결을 기다리고 있습니다");
			Thread.sleep(1000);
			Socket socket = serverSocket.accept();
			System.out.println("클라이언트와 연결되었습니다.");
			is = socket.getInputStream();
			os = socket.getOutputStream();
			dos = new DataOutputStream(os);
			dis = new DataInputStream(is);
			System.out.println("게임을 시작합니다!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Random random = new Random();
			int severBall[] = new int[3];
			for (int i = 0; i < severBall.length; i++) {
				severBall[i] = random.nextInt(9) + 1;
				for (int j = 0; j < i; j++) {
					if (severBall[i] == severBall[j]) {
						i--;
					}
				}
			}
			System.out.println("서버의 번호 : " + severBall[0] + " " + severBall[1] + " " + severBall[2]);

			while (true) {
				gameNum = dis.readUTF();
				StringTokenizer st = new StringTokenizer(gameNum);

				if (st.countTokens() != 3) {
					result = "오류";
					dos.writeUTF(result);
					continue;
				}

				int[] CliNum = new int[3];
				CliNum[0] = Integer.parseInt(st.nextToken());
				CliNum[1] = Integer.parseInt(st.nextToken());
				CliNum[2] = Integer.parseInt(st.nextToken());
				System.out.println("클라이 언트 번호 : " + CliNum[0] + " " + CliNum[1] + " " + CliNum[2]);

				// 게임시작
				for (int i = 0; i < severBall.length; i++) {
					if (severBall[i] == CliNum[i]) {
						Strike++;
					}
					for (int j = 0; j < severBall.length; j++) {
						if (i != j && severBall[i] == CliNum[j]) {
							ball++;
						}
					}
				}
				// 게임식 종료//
				if (Strike == 3) {
					result = "게임종료";
					dos.writeUTF(result);
					break;
				}

				// 결과 식 전송//
				result = Strike + " 스트라이크 / " + ball + "볼";
				dos.writeUTF(result);
				///////

				// 변수 초기화
				Strike = 0;
				ball = 0;

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("게임오버!!!");
		
		try {
		dis.close();
		dos.close();
		os.close();
		is.close();
			serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
