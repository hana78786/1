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
			System.out.println("Ŭ���̾�Ʈ�� ��û�� ��ٸ��� �ֽ��ϴ�");
			
			Socket socket = serversocket.accept();
			System.out.println("Ŭ���̾�Ʈ�� ���ӵǾ����ϴ�");
			is = socket.getInputStream();
			os = socket.getOutputStream();
			
			while(true) {
			
			byte[] b = new byte[100];
			int dataRead;
			dataRead=is.read(b);			
			String data = new String(b,0,dataRead);		
			System.out.println("���� : "+data);
			
			if(data.equals("����")) break;
			
			System.out.println("�� :");
			Scanner scan = new Scanner(System.in);
			data=scan.nextLine();
			b=data.getBytes();
			os.write(b);
			
			if(data.equals("����")) break;
			
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		
	}
}
