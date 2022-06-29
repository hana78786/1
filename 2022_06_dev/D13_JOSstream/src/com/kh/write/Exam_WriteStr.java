package com.kh.write;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Exam_WriteStr {
	public static void main(String[] args) {
		Writer writer = null;
		
		try {
			writer = new FileWriter("filewriter.txt");
			String data = "자바가 제일 쉬웠어요";
			
			writer.write(data);			//문자열 그대로 넣어준다
			writer.write(data, 0, 2);  // 이러면 추가로 자바 두글자만 추가됨!!
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
