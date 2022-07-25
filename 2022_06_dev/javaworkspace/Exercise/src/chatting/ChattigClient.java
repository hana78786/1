package chatting;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ChattigClient {
	public static void main(String[] args) {
		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;
		Scanner scan = new Scanner(System.in);
		String adress = "127.0.0.1";
		int port = 4885;
		String message ="";
		String sendMsg="";
		
		try {
			socket = new Socket(adress, port);
			System.out.println("채팅 서버에 접속합니다");
			Thread.sleep(1000);
			is = socket.getInputStream();
			os = socket.getOutputStream();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true) {
		try {
			byte[] bytes = new byte[100];
			int readByte = is.read(bytes);
			message = new String(bytes,0,readByte);
			System.out.println("상대 : "+message);
			
			System.out.print("나 : ");
			sendMsg = scan.nextLine();
			byte[] bytes1 = sendMsg.getBytes();
			os.write(bytes1);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		

		
	}

}
