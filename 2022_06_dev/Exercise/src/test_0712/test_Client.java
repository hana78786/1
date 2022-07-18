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
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", 8886);
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			Scanner sc = new Scanner(System.in);

//			while (true) {
//
//				byte b[] = new byte[100];
//				int readByte = is.read(b);
//				String data = new String(b, 0, readByte);
//				System.out.println("상대 :" + data);
//				if (data.equals("끝"))break;
//				
//				System.out.print("나:");
//				data= sc.nextLine();
//				byte b1[] =data.getBytes();
//				os.write(b1);
//				if (data.equals("끝"))break;
//
//			}
			while (true) {
				
				DataInputStream dis = new DataInputStream(is);
				String data= dis.readUTF();
				
				System.out.println("상대 :" + data);
				if (data.equals("끝"))break;
				
				System.out.print("나:");
				data=sc.nextLine();
				DataOutputStream dos = new DataOutputStream(os);
				dos.writeUTF(data);
			
				if (data.equals("끝"))break;
				
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
