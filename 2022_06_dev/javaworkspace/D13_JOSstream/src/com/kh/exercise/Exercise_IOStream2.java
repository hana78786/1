package com.kh.exercise;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Scanner;

public class Exercise_IOStream2 {
	public static void main(String[] args) {
		/*
		 * 저장할 파일명 입력 : khtext.txt 'khtext.txt'' 파일에 저장될 내용 입력 : 종료는 exit 1 : 1111 2 :
		 * text input 3 : good 4 : gogogo 5 : exit 파일 저장 완료 (exit는 제외하고 저장)
		 * 
		 */
		Scanner sc = new Scanner(System.in);
		String data = "";
		String fileName;
		Writer writer = null;

		try {
			System.out.println("저장할 파일명 입력 : ");
			fileName = sc.next();	
			
			writer = new FileWriter(fileName);	//스트림을 연다
			
			System.out.println(fileName+"에 저장될 내용 입력");
			System.out.println("종료는 exit");
			
			
			int lineNumber = 1;
			
			
			while (!data.equals("exit\n")) {
				System.out.println(lineNumber++ + " : ");
				writer.write(data);
				data = sc.next()+"\n";
					
			}
			writer.flush(); //스트림을 비워서 쓰기를 완료
			System.out.println("쓰기 완료");	//단순 출력용
			


			System.out.println("파일저장 완료");

		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
