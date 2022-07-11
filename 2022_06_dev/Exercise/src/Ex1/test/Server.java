package Ex1.test;

import java.io.DataInputStream;

import java.io.DataOutputStream;

import java.net.ServerSocket;

import java.net.Socket;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Server {

	public static void main(String[] args) throws Exception {

		SimpleDateFormat from = new SimpleDateFormat("yyMMdd");

		SimpleDateFormat to = new SimpleDateFormat("yyyy년 MM월 dd일 (E)");

		ServerSocket server = new ServerSocket(25000);

		

			Socket sock = server.accept();


			DataInputStream dis = new DataInputStream(sock.getInputStream());

			DataOutputStream dos = new DataOutputStream(sock.getOutputStream());

			String target = dis.readUTF();

			try {

				Date date = from.parse(target);

				String result = to.format(date);

				dos.writeUTF(result);

			} catch (Exception e) {

				dos.writeUTF("날짜 형식이 잘 못 되었습니다.");

			}

			dos.flush();

		

	}

}