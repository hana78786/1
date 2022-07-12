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
		Socket socket = null;
		InputStream in = null;
		OutputStream os = null;
		
		socket = new Socket("127.0.0.1",8889);
		in = socket.getInputStream();
		os = socket.getOutputStream();
		
		System.out.print("³ª:");
		Scanner scan = new Scanner (System.in);
		String data = scan.nextLine();
		byte b[] = data.getBytes();
		os.write(b);
		os.flush();
		byte b1[] = new byte [100];
		
		int read = in.read(b1);
		data = new String(b1,0,read);
			
		System.out.println(data);
		
		DataInputStream dis = new DataInputStream(in);
		DataOutputStream dos = new DataOutputStream(os);
		System.out.println("³ª:");
		dos.writeUTF(scan.next());
		System.out.println("2"+dis.readUTF());
	}

}
