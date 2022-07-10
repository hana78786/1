package BasballGame2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Random;
import java.util.StringTokenizer;

public class Server {
	public static void main(String[] args) throws EOFException {
		ServerSocket serverSocket = null;
		InputStream is = null;
		OutputStream os = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		int port = 8889;
		DateFormat df= new SimpleDateFormat("HH:MM:ss");
		String time = df.format(new Date());

		try {
			serverSocket = new ServerSocket(port);
			System.out.println("클라이언트의 응답을 기다립니다");
			Thread.sleep(300);
			Socket socket = serverSocket.accept();
			is = socket.getInputStream();
			os = socket.getOutputStream();
			System.out.println("클라이언트와 연결되었습니다.");
			System.out.println(time);
			Thread.sleep(300);

			dos = new DataOutputStream(os);
			dis = new DataInputStream(is);
			System.out.println("게임을 시작합니다.");

			// 숫자 선별 시작
			int[] SerNum = new int[3];
			Random random = new Random();
			System.out.print("서버가 선별한 번호 : ");
			System.out.println();

			for (int i = 0; i < 3; i++) {
				SerNum[i] = random.nextInt(9) + 1;
				for (int j = 0; j < i; j++) {// 중복제거
					if (SerNum[i] == SerNum[j]) {
						i--;
						continue;
					}
				}
			}
			System.out.print(SerNum[0] + " " + SerNum[1] + " " + SerNum[2] + " ");
			System.out.println();
			String score ="";
			int Strike = 0;
			int ball = 0;
			
			while (true) {
				// 클라이언트가 보낸 숫자 수신
				String CliNum = dis.readUTF();
				StringTokenizer st = new StringTokenizer(CliNum, " ");
				int CliNum1[] = new int[3];
				
				if (st.countTokens() != 3) {//입력오류일때
					score = "잘못된입력입니다";
				} else {
					CliNum1[0] = Integer.parseInt(st.nextToken());
					CliNum1[1] = Integer.parseInt(st.nextToken());
					CliNum1[2] = Integer.parseInt(st.nextToken());
					
					// 점수 카운트 시작
				
					for (int i = 0; i < SerNum.length; i++) {
						if (SerNum[i] == CliNum1[i]) {
							Strike++;
						} else {
							for (int j = 0; j < CliNum1.length; j++) {
								if (SerNum[i] == CliNum1[j]) {
									ball++;
								}
							}
						}
					}

					System.out.println("클라이언트 입력 : " + CliNum); 
					System.out.println();

					score = "스트라이크 " + Strike + " 볼 " + ball;
					
					if (Strike == 3) {
						score = "3 스트라이크 게임종료";
					}
				}

					dos.writeUTF(score);

					if (Strike == 3)
						break;

					Strike = 0;
					ball = 0;
				
			}
			System.out.println("게임을 종료합니다");
			String time1=df.format(new Date());
			System.out.println(time1);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				dos.close();
				dis.close();
				serverSocket.close();
				is.close();
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
