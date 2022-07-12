package test_0712;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class testServer {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(8886);
		Socket socket = serverSocket.accept();
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		DataInputStream dis = new DataInputStream(is);
		DataOutputStream dos = new DataOutputStream(os);
		Scanner scan = new Scanner(System.in);
		
		String data="";
//		while(!data.equals("끝")) {
//			System.out.print("상대 :");
//			byte[] b = new byte[5];
//			int readByte = is.read(b);
//			data = new String(b,0,readByte);
//			System.out.println(data);
//			
//			System.out.print("나 :");
//			data = scan.nextLine();
//			byte b1[] = data.getBytes();
//					os.write(b);
//			System.out.println(data);
//		}
		
		while(!data.equals("끝")) {
			System.out.print("상대 :");
			data = dis.readUTF();
			System.out.println(data);
			
			System.out.println("나 :");
			data = scan.nextLine();
			dos.writeUTF(data);
			
			
		}
	

	}
	
	
	
	
	
	
}
