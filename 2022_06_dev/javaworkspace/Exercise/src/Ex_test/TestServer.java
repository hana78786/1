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
		SimpleDateFormat to = new SimpleDateFormat("yyyy�� MM�� dd�� (E)");
		
		
		
		System.out.println("Ŭ���̾�Ʈ�� �������Դϴ�.");
		Socket sock = server.accept();
		System.out.println("Ŭ���̾�Ʈ�� ����Ǿ����ϴ�");
		DataInputStream dis = new DataInputStream(sock.getInputStream());
		DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
		
		String data = dis.readUTF();
		Date date = from.parse(data);
		String answer = to.format(date);
		
		dos.writeUTF(answer);
		
		
		
	}

}
