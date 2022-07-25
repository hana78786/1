package chatting;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChattigServer {
	public static void main(String[] args) {
		ServerSocket severSocket = null;
		InputStream is = null;
		OutputStream os = null;
		int port = 4885;
		String message = "";
		String sendMsg = "";
		Scanner scan = new Scanner(System.in);
		try {
			System.out.println("서버에 접속중입니다");
			Thread.sleep(1000);
			severSocket = new ServerSocket(port);
			Socket socket = severSocket.accept();
			is = socket.getInputStream();
			os = socket.getOutputStream();
			System.out.println("채팅을 시작합니다");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while (true) {
			try {
				System.out.print("나 : ");
				sendMsg = scan.nextLine();
				byte[] bytes = sendMsg.getBytes();
				os.write(bytes);

				byte[] bytes1 = new byte[100];
				int readByte = is.read(bytes1);
				message = new String(bytes1, 0, readByte);
				System.out.println("상대 : " + message);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
