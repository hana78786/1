package com.kh.write;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Exam_WriteStr {
	public static void main(String[] args) {
		Writer writer = null;
		
		try {
			writer = new FileWriter("filewriter.txt");
			String data = "�ڹٰ� ���� �������";
			
			writer.write(data);			//���ڿ� �״�� �־��ش�
			writer.write(data, 0, 2);  // �̷��� �߰��� �ڹ� �α��ڸ� �߰���!!
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
