package com.kh.inputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Exam_ReadByte {
	public static void main(String [] args) {
		InputStream is =null;
		
		try {
			is = new FileInputStream("inputStream.txt");
			///////////////////////////
			int readByteNo;
			//////////////////////////
			byte [] readByte = new byte[10]; // 배열의 크기만큼 읽는다
			//abcd의 경우 abc씩 4인경우는 abcd씩 읽는다.
			String data = "";
			//////////////////////////
			while(true) {
				readByteNo = is.read(readByte); //ReadByteNo=3 readByte=ABC
				//is.read는 글자의 수를 세어 읽는다. 공백이 포함되어도
				//글자의 수만 파악한다.
				if(readByteNo==-1)break;
				data+= new String(readByte,0,readByteNo);
			}
			System.out.println(data);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
