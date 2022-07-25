package com.kh.write;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Exam_Writer {
	public static void main(String[] args) {
		Writer writer = null;

		try {
			writer = new FileWriter("filewriter.txt");	//스트림을 연다
			char [] data = "이거슨 자바다".toCharArray(); //문자열을 문자 배열로 만든다
			for(int i =0; i<data.length;i++) {
				writer.write(data[i]);//배열의 길이까지 반복 쓰기중
			}
			writer.flush(); //스트림을 비워서 쓰기를 완료
			System.out.println("쓰기 완료");	//단순 출력용
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
