package com.kh.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Exam_ReadCharOff {
	public static void main(String[] args) {
		Reader reader = null;
		//Reader  reader = new FileReader("filereader.txt");
		//라고 한번에 선언하지 않는 이유는  Reader는 예외처리가 필요하기때문에 trycatch에 들어간다
		//finally에서 reader를 닫아주려면 reader는 전역변수여아하는데 try안에 들어가면 지역변수가된다.
		//그래서 일부러 reder를 먼저 선언한다.
		

		try {

			reader = new FileReader("filereader.txt");
			int readCharNo; // 미사용 변수
			char[] cbuf = new char[4];
			readCharNo = reader.read(cbuf, 0, 3);
			//배열을 초기화 시켜준다.
			for (int i = 0; i < cbuf.length; i++) {
				System.out.println(cbuf[i]);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {

				reader.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
