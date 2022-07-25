package Ex_test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestServer {
	public static void main(String[] args) throws IOException, ParseException {
		ServerSocket server = new ServerSocket(25000);
		SimpleDateFormat from = new SimpleDateFormat("yyMMdd");
		SimpleDateFormat to = new SimpleDateFormat("yyyy년 MM월 dd일 (E)");
		
		
		
		System.out.println("클라이언트와 연결중입니다.");
		Socket sock = server.accept();
		System.out.println("클라이언트와 연결되었습니다");
		DataInputStream dis = new DataInputStream(sock.getInputStream());
		DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
		
		String data = dis.readUTF();
		Date date = from.parse(data);
		String answer = to.format(date);
		
		dos.writeUTF(answer);
		
		
		
	}

}
