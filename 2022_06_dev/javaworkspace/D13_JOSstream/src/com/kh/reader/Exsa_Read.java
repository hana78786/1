package com.kh.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class Exsa_Read {
public static void main(String[] args) {
	InputStream is = null; // 바이트기반 스트림의 조상클래스
	Reader reader = null; // 문자기반 스트림의 조상클래스 이걸 사용!
	
	try {
		reader = new FileReader("filereader.txt");
		int readData; // 읽은 데이터 저장
//		while(true) {
		while((readData = reader.read()) != 1) {
//			readData = reader.read(); // 읽을게 업을때까지 읽는 코드
//			if(readData==-1) break; // 무한반복을 빠져나오기 위한 조건식
			System.out.print((char)readData); // 이러면 숫자가 나온다! 문자로 출력해야함!
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
}
