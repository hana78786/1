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
			System.out.println("������ �������Դϴ�");
			Thread.sleep(1000);
			severSocket = new ServerSocket(port);
			Socket socket = severSocket.accept();
			is = socket.getInputStream();
			os = socket.getOutputStream();
			System.out.println("ä���� �����մϴ�");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while (true) {
			try {
				System.out.print("�� : ");
				sendMsg = scan.nextLine();
				byte[] bytes = sendMsg.getBytes();
				os.write(bytes);

				byte[] bytes1 = new byte[100];
				int readByte = is.read(bytes1);
				message = new String(bytes1, 0, readByte);
				System.out.println("��� : " + message);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
