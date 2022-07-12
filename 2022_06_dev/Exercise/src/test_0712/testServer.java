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
	
	ServerSocket severSocket = null;
	Socket socket=null;
	InputStream in = null;
	OutputStream os = null;
	
	severSocket = new ServerSocket(8889);
	socket = severSocket.accept();
	in = socket.getInputStream();
	os = socket.getOutputStream();
	System.out.print("상대: ");
	byte[] b = new byte [100];
	int read = 0;
	String data = "";
	
	read = in.read(b);
	data = new String(b,0,read);
	
	System.out.println(data);
	System.out.print("나:");
	Scanner scan = new Scanner(System.in);
	data = scan.nextLine();
	byte b1[] = data.getBytes();
	
	os.write(b1);

	DataInputStream dis = new DataInputStream(in);
	DataOutputStream dos = new DataOutputStream(os);
	
	
	System.out.println("2"+dis.readUTF());
	System.out.print("나 :");
	dos.writeUTF(scan.next());

	}
	
	
	
	
	
	
}
