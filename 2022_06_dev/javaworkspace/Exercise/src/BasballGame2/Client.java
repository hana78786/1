package BasballGame2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		int port = 8889;
		String address = "127.0.0.1";

		System.out.println("서버와 연결을 준비합니다");

		try {
			socket = new Socket(address, port);
			is = socket.getInputStream();
			os = socket.getOutputStream();
			dis = new DataInputStream(is);
			dos = new DataOutputStream(os);
			System.out.println("서버와 연결되었습니다");
			Thread.sleep(300);
			System.out.println("게임을 시작합니다");
			Thread.sleep(300);
			System.out.println("베이스볼 게임!!");
			Thread.sleep(300);
			
		
			while(true) {
				
				
			System.out.println("10미만의 숫자 세개를 입력하세요! 숫자는 띄어쓰기로 구분합니다.");
			Scanner scan = new Scanner(System.in);
			String CliNum = scan.nextLine();
			
			dos.writeUTF(CliNum);
			String score = dis.readUTF();
			System.out.println(score);
			if(score.equals("3 스트라이크 게임종료")) {
				System.out.println("게임 승리! 게임을 종료합니다");
				break;
			}
			
			
			}
			

			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				dos.close();
				dis.close();
				socket.close();
				is.close();
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			
		}

	}

}
