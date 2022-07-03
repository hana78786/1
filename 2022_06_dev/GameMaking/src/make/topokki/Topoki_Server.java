package make.topokki;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Topoki_Server {

	static String quizNum[] = new String[10];
	static boolean quizAnswer[] = new boolean[10];

	public static void main(String[] args) {
		ServerSocket severSocket = null;
		InputStream is = null;
		OutputStream os = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		int port = 8889;
		int a =0;

		try {
			System.out.println("서버를 연결합니다");
			severSocket = new ServerSocket(port);
			System.out.println("클라이언트의 접속을 기다립니다.");
			Socket socket = severSocket.accept();
			System.out.println("클라이언트가 접속하였습니다");
			is = socket.getInputStream();
			os = socket.getOutputStream();
			dis = new DataInputStream(is);
			dos = new DataOutputStream(os);

			System.out.println("게임을 시작합니다");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		종료: while (a!=9999) {
			try {
				while (a!=9999) {
					a = dis.readInt();
					if(a==9999)//게임종료코드
					{break 종료;}
					
					
					quizNum[0] = "자바의 특징 5가지는 아래와 같다\n 1) 객체 지향 프로그래밍(OOP) \n 2) 자동 메모리 관리(gc)\n 3) 운영체제에 독립적 \n 4) 멀티쓰레드 지원  5)동적 로딩 지원\n";
					quizNum[1] = "캡술화 과정에서 정보 은닉을 위해 변수는 public으로 메서드는 private으로 선언한다";
					quizNum[2] = "인터페이스는 단일 상속만 가능하다";
					quizNum[3] = "부모-자식 클래스는 단일 상속만 가능하다";
					quizNum[4] = "String과 float, int의 크기는 4바이트로 같다";
					quizNum[5] = "a = 1 ; b = 2 ; \n" + "c = ++a + b--; 일때 c의 값은 3이다 ";
					quizNum[6] = "final은 변수명으로 사용할 수 있다";
					quizNum[7] = "1_num은 변수명으로 사용할 수 없다";
					quizNum[8] = "String a =\"2\" ; String b =\"3\"; 일때 \n System.out.println(a+b);의 값은 5이다";

					quizNum[9] = "String a =\"2\" ; String b =\"3\"; 일때 \n System.out.println(a+b);의 값은 23이다";

					boolean quizAnswer[] = {true, false, false, true, true, false, false, true, false, true };// 답 모음
					
					
					dos.writeUTF(quizNum[a]);

					System.out.println(a);
					System.out.println(quizNum[a]);
					System.out.println("정답은 " + quizAnswer[a]);

					String answer = dis.readUTF();
					if ((answer.equalsIgnoreCase("o") && quizAnswer[a] == true)
							|| (answer.equalsIgnoreCase("x") && quizAnswer[a] == false)) {
						dos.writeUTF("정답");
						System.out.println("클라이언트가 정답을 맞췄습니다");
					} else if ((answer.equalsIgnoreCase("x") && quizAnswer[a] == true)
							|| (answer.equalsIgnoreCase("o") && quizAnswer[a] == false)) {
						dos.writeUTF("오답");
						System.out.println("클라이언트가 정답을 맞추지 못했습니다.");
					} else {

					}
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("게임을 종료합니다.");
		try {
			dis.close();
			dos.close();
			is.close();
			os.close();
			severSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



}
