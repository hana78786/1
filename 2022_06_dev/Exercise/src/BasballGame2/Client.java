package BasballGame2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		int port = 8889;
		String address = "127.0.0.1";

		System.out.println("������ ������ �غ��մϴ�");

		try {
			socket = new Socket(address, port);
			is = socket.getInputStream();
			os = socket.getOutputStream();
			dis = new DataInputStream(is);
			dos = new DataOutputStream(os);
			System.out.println("������ ����Ǿ����ϴ�");
			Thread.sleep(300);
			System.out.println("������ �����մϴ�");
			Thread.sleep(300);
			System.out.println("���̽��� ����!!");
			Thread.sleep(300);
			
		
			while(true) {
				
				
			System.out.println("10�̸��� ���� ������ �Է��ϼ���! ���ڴ� ����� �����մϴ�.");
			Scanner scan = new Scanner(System.in);
			String CliNum = scan.nextLine();
			
			dos.writeUTF(CliNum);
			String score = dis.readUTF();
			System.out.println(score);
			if(score.equals("3 ��Ʈ����ũ ��������")) {
				System.out.println("���� �¸�! ������ �����մϴ�");
				break;
			}
			
			
			}
			

			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				dos.close();
				dis.close();
				socket.close();
				is.close();
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			
		}

	}

}
