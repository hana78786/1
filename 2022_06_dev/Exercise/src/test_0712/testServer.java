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
	public static void main(String[] args) {
		ServerSocket server = null;
		InputStream in = null;
		OutputStream os = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			server = new ServerSocket(8886);
			Socket socket = server.accept();
			in = socket.getInputStream();
			os = socket.getOutputStream();
			
//			while(true) {
//				System.out.print("나 :");
//				String data = sc.nextLine();
//				byte b[] = data.getBytes();
//				os.write(b);
//				if (data.equals("끝"))break;
//				
//				
//				byte b1 [] = new byte[100];
//				int readByte = in.read(b1);
//				data = new String(b1,0,readByte);
//				System.out.println("상대 :"+data);
//				
//				if (data.equals("끝"))break;
//				
//			}
			while(true) {
				System.out.print("나 :");
				String data = sc.nextLine();
				DataOutputStream dos = new DataOutputStream(os);
				dos.writeUTF(data);
				
				if (data.equals("끝"))break;
				
				DataInputStream dis = new DataInputStream(in);
				dis.readUTF();
				
				
				System.out.println("상대 :"+data);
				
				if (data.equals("끝"))break;
				
			}
			
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	

	}
	
	
	
	
	
	
}
