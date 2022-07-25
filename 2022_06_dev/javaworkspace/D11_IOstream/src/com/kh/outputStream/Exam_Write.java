package com.kh.outputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Exam_Write {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os = new FileOutputStream("outStream.txt"); //스트림을 연다
			byte[] data = "Hello I/O".getBytes();//문자열을 byte배열로 만든다
			for(int i =0; i<data.length;i++) {//바이트배열을 파일에 쓴다
				os.write(data[i]);
			}
			os.flush(); //스트림을 비워서 쓰기를완료한다.
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
