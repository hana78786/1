package com.kh.inputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Exam_Read {
	public static void main (String[] args){
		InputStream is =null;
		
		try {
			is = new FileInputStream("inputStream.txt");
			int readByte; 
			while(true) {
				readByte= is.read();
				if(readByte == -1) {break;} //���ڰ� ������ -1�̵�  ������ �� (-1)
				System.out.print((char)readByte);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //checked exeption -> �ݵ�� ����ó��!
 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	
	}

}
