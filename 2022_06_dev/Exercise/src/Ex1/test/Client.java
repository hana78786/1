package Ex1.test;

import java.io.DataInputStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import java.util.Scanner;

public class Client {

public static void main(String[] args) throws Exception{

Scanner sc = new Scanner(System.in);

Socket sock = new Socket("127.0.0.1", 25000);

//InputStream is = sock.getInputStream();
//OutputStream os = sock.getOutputStream();
//DataInputStream dis = new DataInputStream(is);
//DataOutputStream dos = new DataOutputStream(os);

DataInputStream dis = new DataInputStream(sock.getInputStream());
DataOutputStream dos = new DataOutputStream(sock.getOutputStream());

System.out.print("�ֹι�ȣ ���ڸ� 6�ڸ��� �Է��ϼ��� : ");

String date = sc.nextLine();

dos.writeUTF(date);

dos.flush();

String result = dis.readUTF();

System.out.println("�����κ����� ��� : " + result);

}

}
