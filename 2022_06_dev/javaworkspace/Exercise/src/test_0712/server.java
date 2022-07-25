package test_0712;


import java.io.DataInputStream;

import java.io.DataOutputStream;

import java.io.IOException;

import java.io.InputStream;

import java.io.OutputStream;

import java.net.ServerSocket;

import java.net.Socket;

import java.text.SimpleDateFormat;

import java.util.Date;

public class server {

public static void main (String[] args){

int port = 9999;

ServerSocket serverSocket = null;

DataInputStream dis = null;

DataOutputStream dos = null;

try {

serverSocket = new ServerSocket(port);

Socket clientSocket = serverSocket.accept();

InputStream in = clientSocket.getInputStream();

OutputStream out = clientSocket.getOutputStream();

//OutputStream out = new OutputStream(); 

dis = new DataInputStream(in);

dos = new DataOutputStream(out);

dos.writeUTF("[서버 연결 성공]");
System.out.println("서버연결성공");

String clientMsg = dis.readUTF(); 
dos.writeUTF(clientMsg);

} catch (IOException e) {

e.printStackTrace();

}finally {

try {

dis.close();

dos.close();

serverSocket.close();

} catch (IOException e) {

e.printStackTrace();

}

}

}

}