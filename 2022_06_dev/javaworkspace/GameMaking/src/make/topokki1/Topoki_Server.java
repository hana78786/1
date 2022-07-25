package make.topokki1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Topoki_Server {

	

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
					
					
					Quizmaker quiz = new Quizmaker();					
					String quizNum = quiz.Quizmaker(a);
					boolean AnswerNum = quiz.Answer(a);
					dos.writeUTF(quizNum);

					System.out.println(a+"번 문제");
					System.out.println(quizNum);
					System.out.println("정답은 " + AnswerNum);

					String answer = dis.readUTF();
					if ((answer.equalsIgnoreCase("o") && AnswerNum == true)
							|| (answer.equalsIgnoreCase("x") && AnswerNum == false)) {
						dos.writeUTF("정답");
						System.out.println("클라이언트가 정답을 맞췄습니다");
					} else if ((answer.equalsIgnoreCase("x") && AnswerNum == true)
							|| (answer.equalsIgnoreCase("o") && AnswerNum == false)) {
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
