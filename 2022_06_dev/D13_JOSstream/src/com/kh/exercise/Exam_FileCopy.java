package com.kh.exercise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Exam_FileCopy {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;

		try {
			is = new FileInputStream("D:\\Temp\\Bab.jpg");
			os = new FileOutputStream("D:\\Temp\\Bab1.jpg");
			int data = 0;
			byte[] readByte = new byte[100];
			while((data = is.read(readByte))!=-1) {				
				//쓰기코드가 필요함	
				os.write(readByte,0,data);
		
			}
			System.out.println("복사가 완료되었습니다.");
			os.flush();
				
			

		}catch(

	FileNotFoundException e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch(
	IOException e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}

}
