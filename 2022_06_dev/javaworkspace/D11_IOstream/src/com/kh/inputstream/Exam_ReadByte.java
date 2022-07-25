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
			byte [] readByte = new byte[10]; // �迭�� ũ�⸸ŭ �д´�
			//abcd�� ��� abc�� 4�ΰ��� abcd�� �д´�.
			String data = "";
			//////////////////////////
			while(true) {
				readByteNo = is.read(readByte); //ReadByteNo=3 readByte=ABC
				//is.read�� ������ ���� ���� �д´�. ������ ���ԵǾ
				//������ ���� �ľ��Ѵ�.
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
