package basballgame;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		Socket socket = null;
		int port = 8889;
		String address = "127.0.0.1";
		InputStream is = null;
		OutputStream os = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		Scanner scan = new Scanner(System.in);
		String gameNum = "";
		String result = "";

		try {
			System.out.println("서버와 연결중입니다.");
			Thread.sleep(1000);
			socket = new Socket(address, port);
			System.out.println("서버와 연결되었습니다.");
			is = socket.getInputStream();
			os = socket.getOutputStream();
			dos = new DataOutputStream(os);
			dis = new DataInputStream(is);
			System.out.println("게임을 시작합니다.");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			while (true) {
				System.out.print("3개 번호를 입력하고 엔터!");
				gameNum = scan.nextLine();
				dos.writeUTF(gameNum);

				result = dis.readUTF();
				if (result.equals("오류")) {
					System.out.println("잘못입력하셨습니다");
					continue;
				}
				
				if (result.equals("게임종료")) {
					System.out.println("게임 승리!");
					break;
				}
				
				
				System.out.println(result);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("게임을 종료합니다.");
		
		try {
			dis.close();
			dos.close();
			scan.close();
			os.close();
			is.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
