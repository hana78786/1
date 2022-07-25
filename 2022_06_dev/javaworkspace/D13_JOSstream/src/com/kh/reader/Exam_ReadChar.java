package com.kh.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Exam_ReadChar {
	public static void main(String[] args) {
		Reader reader = null; // 문자기반 스트림을 인트탠스화 했다
		try {
			reader = new FileReader("filereader.txt");
			int readCharNo; 
			char[] cbuf = new char[2];
			String data = "";
			while ((readCharNo = reader.read(cbuf)) != -1) {
					// readCharNo = cbuf를 읽은 숫자이다. 
					//cbuf는 배열이 2이기때문에 문자를 2개씩 읽는다.
					//공백이면 0을 읽는다
					//값이 없으면 -1을 읽는다.
					//-1을 읽으면 반복이 종료된다.
				data += new String(cbuf, 0, readCharNo); 
				// 문자배열의 문자를 문자로 바꾸는 과정
				// new String(byte[] bytes, int offset, int length);
				// new String(바이트배열, 시작 인덱스 순서 근데 왜 다른숫자를 넣으면 안되지? , 길이의 크기);
				 
			}
			System.out.println(data);
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
