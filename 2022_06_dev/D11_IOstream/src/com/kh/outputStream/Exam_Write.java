package com.kh.outputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Exam_Write {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os = new FileOutputStream("outStream.txt"); //��Ʈ���� ����
			byte[] data = "Hello I/O".getBytes();//���ڿ��� byte�迭�� �����
			for(int i =0; i<data.length;i++) {//����Ʈ�迭�� ���Ͽ� ����
				os.write(data[i]);
			}
			os.flush(); //��Ʈ���� ����� ���⸦�Ϸ��Ѵ�.
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
