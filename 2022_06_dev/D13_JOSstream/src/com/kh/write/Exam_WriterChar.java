package com.kh.write;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Exam_WriterChar {
	public static void main(String[] args) {
		Writer writer =null;
		
		try {
			writer= new FileWriter("filewriter.txt");
			char[] data = "�̰��� �ڹ���~~".toCharArray();
			writer.write(data); //for�� ���� ��������
			System.out.println("�����Ϸ�!");
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
