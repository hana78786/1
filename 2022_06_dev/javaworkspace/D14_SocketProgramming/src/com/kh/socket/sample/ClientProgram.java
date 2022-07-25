package com.kh.socket.sample;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientProgram {
	@SuppressWarnings("null")
	public static void main(String[] args) {
		Socket socket = null;
		// ���� ��ü�� �����ϴ°��� ��û

		try {
			System.out.println("�����û");
			socket = new Socket("127.0.0.1", 4885);
			// �� ��ǻ���� �ּ� : ����� ��(��¥ip�� �ƴϾ�!)
			System.out.println("���Ἲ��!");

			////////////////// �����ͺ�����////////////
			byte[] bytes = null;
			String message = null;

			OutputStream os = socket.getOutputStream();
			message = "Hello Server";
			bytes = message.getBytes();
			os.write(bytes);
			os.flush();
			System.out.println("������ ���� �Ϸ�");
			
			/////������ �ޱ�//////
			InputStream is = socket.getInputStream();
			bytes = new byte[100];
			int readByte = is.read(bytes);
			message = new String(bytes,0,readByte);
			System.out.println("���۹��� ������ : " + message);

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
