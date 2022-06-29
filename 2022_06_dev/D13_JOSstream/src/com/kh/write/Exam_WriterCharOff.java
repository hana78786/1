package com.kh.write;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Exam_WriterCharOff {
	public static void main(String[] args) {
		Writer writer = null;
		
		try {
			writer = new FileWriter("filewriter.txt");
			char[] cbuf = "�ڹٴ� Ŀ����".toCharArray();
			writer.write(cbuf, 0, 2); // �迭, ������ġ, ��������ġ(�ε��� -1)
			writer.flush();
			System.out.println("���� ���� �Ϸ�!");
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
