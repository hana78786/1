package test_0712;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class test_Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1", 8886);
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		DataInputStream dis = new DataInputStream(is);
		DataOutputStream dos = new DataOutputStream(os);
		Scanner scan = new Scanner(System.in);
	
		
		String data = "";
//		while (!data.equals("끝")) {
//			System.out.print("나 :");
//			data = scan.nextLine();
//			byte[] b = data.getBytes();
//			os.write(b);
//			
//			System.out.print("상대 :");
//			byte b1[] = new byte[5];
//			int readByte = is.read(b1);
//			data = new String(b1,0,readByte);
//			System.out.println(data);
//
//		}
		while (!data.equals("끝")) {
			System.out.println("나 :");
			data= scan.nextLine();
			dos.writeUTF(data);
			
			System.out.println("상대 :");
			data = dis.readUTF();
			System.out.println(data);

		}

	}

}
