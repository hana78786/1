package chatting2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;


public class Client {
	public static void main(String[] args) {
		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;
		int port =8889;
		String address = "127.0.0.1";
		Scanner scan = new Scanner(System.in);
		
		try {
			socket = new Socket(address, port);
			System.out.println("������ �����մϴ�");
			
			
			is= socket.getInputStream();
			os=socket.getOutputStream();
			
			while(true) {
			System.out.println("�� : ");
			String data = scan.next();
			
			byte[] b = data.getBytes();
			os.write(b);
			
			if(data.equals("����")) break;
			
			b=new byte[100];
			int readByte = is.read(b);
			data = new String(b,0,readByte);
			
			if(data.equals("����")) break;
			
			
			
			}
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
