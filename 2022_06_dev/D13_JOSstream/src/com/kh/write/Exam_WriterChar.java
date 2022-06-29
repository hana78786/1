package com.kh.write;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Exam_WriterChar {
	public static void main(String[] args) {
		Writer writer =null;
		
		try {
			writer= new FileWriter("filewriter.txt");
			char[] data = "이것이 자바임~~".toCharArray();
			writer.write(data); //for문 없이 생성가능
			System.out.println("생성완료!");
			writer.flush();
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
