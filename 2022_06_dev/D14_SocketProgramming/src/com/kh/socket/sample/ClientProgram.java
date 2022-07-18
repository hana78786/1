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
		// 소켓 객체를 생성하는것이 요청

		try {
			System.out.println("연결요청");
			socket = new Socket("127.0.0.1", 4885);
			// 내 컴퓨터의 주소 : 나라는 뜻(진짜ip가 아니야!)
			System.out.println("연결성공!");

			////////////////// 데이터보내기////////////
			byte[] bytes = null;
			String message = null;

			OutputStream os = socket.getOutputStream();
			message = "Hello Server";
			bytes = message.getBytes();
			os.write(bytes);
			os.flush();
			System.out.println("데이터 전송 완료");
			
			/////데이터 받기//////
			InputStream is = socket.getInputStream();
			bytes = new byte[100];
			int readByte = is.read(bytes);
			message = new String(bytes,0,readByte);
			System.out.println("전송받은 데이터 : " + message);

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
