package com.kh.exercise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Exam_FileInputStream {
	

	public static void main(String[] args) {
		InputStream is = null;
		
		

		try {
			is = new FileInputStream(
					"D:\\user\\github\\1\\1\\2022_06_dev\\D13_JOSstream\\src\\com\\kh\\exercise\\Exam_FileInputStream.java");
//			String data = "";
//			data = is.toString();
//			System.out.println(data); //왜 안되지?
			//is는 stream이기때문이 직접적으로 String으로는 바뀔수 없대!
//			System.out.println(is.read(b));

			int readByte =0;
			byte[] buf = new byte[200];
			String result ="";
			while((readByte = is.read(buf))!=-1) {
				result+= new String(buf,0,readByte);
			}
			System.out.print(result);
//			while (readByte != -1) {
//				readByte = is.read();
//
//				System.out.print((char) readByte);
//			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
