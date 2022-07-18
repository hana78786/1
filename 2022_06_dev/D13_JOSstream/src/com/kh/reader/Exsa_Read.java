package com.kh.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class Exsa_Read {
public static void main(String[] args) {
	InputStream is = null; // ����Ʈ��� ��Ʈ���� ����Ŭ����
	Reader reader = null; // ���ڱ�� ��Ʈ���� ����Ŭ���� �̰� ���!
	
	try {
		reader = new FileReader("filereader.txt");
		int readData; // ���� ������ ����
//		while(true) {
		while((readData = reader.read()) != 1) {
//			readData = reader.read(); // ������ ���������� �д� �ڵ�
//			if(readData==-1) break; // ���ѹݺ��� ���������� ���� ���ǽ�
			System.out.print((char)readData); // �̷��� ���ڰ� ���´�! ���ڷ� ����ؾ���!
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
}
