package com.kh.write;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Exam_WriterCharOff {
	public static void main(String[] args) {
		Writer writer = null;
		
		try {
			writer = new FileWriter("filewriter.txt");
			char[] cbuf = "자바는 커피임".toCharArray();
			writer.write(cbuf, 0, 2); // 배열, 시작위치, 마지막위치(인덱스 -1)
			writer.flush();
			System.out.println("파일 쓰기 완료!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
