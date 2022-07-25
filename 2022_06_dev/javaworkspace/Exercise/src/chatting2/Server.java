package chatting2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) {
		ServerSocket serversocket = null;
		InputStream is = null;
		OutputStream os = null;
		int port =8889;
		
		try {
			serversocket = new ServerSocket(port);
			System.out.println("클라이언트의 요청을 기다리고 있습니다");
			
			Socket socket = serversocket.accept();
			System.out.println("클라이언트와 접속되었습니다");
			is = socket.getInputStream();
			os = socket.getOutputStream();
			
			while(true) {
			
			byte[] b = new byte[100];
			int dataRead;
			dataRead=is.read(b);			
			String data = new String(b,0,dataRead);		
			System.out.println("상대방 : "+data);
			
			if(data.equals("종료")) break;
			
			System.out.println("나 :");
			Scanner scan = new Scanner(System.in);
			data=scan.nextLine();
			b=data.getBytes();
			os.write(b);
			
			if(data.equals("종료")) break;
			
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		
	}
}
