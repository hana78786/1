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

		SimpleDateFormat to = new SimpleDateFormat("yyyy�� MM�� dd�� (E)");

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

				dos.writeUTF("��¥ ������ �� �� �Ǿ����ϴ�.");

			}

			dos.flush();

		

	}

}