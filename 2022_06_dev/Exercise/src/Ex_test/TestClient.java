package Ex_test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TestClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket sock = new Socket("127.0.0.1",25000);
		Scanner sc = new Scanner(System.in);
		System.out.println("서버와 연결되었습니다");
		
		DataInputStream dis = new DataInputStream(sock.getInputStream());
		DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
		System.out.println("날짜를 입력하세요");
		String data = sc.nextLine();
		dos.writeUTF(data);
		String date = dis.readUTF();
		System.out.println(date);
		
	}
	

}
