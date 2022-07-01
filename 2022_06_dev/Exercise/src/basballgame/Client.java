package basballgame;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		Socket socket = null;
		int port = 8889;
		String address = "127.0.0.1";
		InputStream is = null;
		OutputStream os = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		Scanner scan = new Scanner(System.in);
		String gameNum = "";
		String result = "";

		try {
			System.out.println("������ �������Դϴ�.");
			Thread.sleep(1000);
			socket = new Socket(address, port);
			System.out.println("������ ����Ǿ����ϴ�.");
			is = socket.getInputStream();
			os = socket.getOutputStream();
			dos = new DataOutputStream(os);
			dis = new DataInputStream(is);
			System.out.println("������ �����մϴ�.");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			while (true) {
				System.out.print("3�� ��ȣ�� �Է��ϰ� ����!");
				gameNum = scan.nextLine();
				dos.writeUTF(gameNum);

				result = dis.readUTF();
				if (result.equals("����")) {
					System.out.println("�߸��Է��ϼ̽��ϴ�");
					continue;
				}
				
				if (result.equals("��������")) {
					System.out.println("���� �¸�!");
					break;
				}
				
				
				System.out.println(result);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("������ �����մϴ�.");
		
		try {
			dis.close();
			dos.close();
			scan.close();
			os.close();
			is.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
