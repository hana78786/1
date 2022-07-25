package com.kh.exercise;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class Exercise_IOStream {
	public static void main(String[] args) {
		/*
		 * 저장할 파일명 입력 : khtext.txt 'khtext.txt'' 파일에 저장될 내용 입력 : 종료는 exit 1 : 1111 2 :
		 * text input 3 : good 4 : gogogo 5 : exit 파일 저장 완료 (exit는 제외하고 저장)
		 * 
		 */
		OutputStream os = null;
		Scanner sc = new Scanner(System.in);
		String data = "";
		String fileName;

		try {

			System.out.println("저장할 파일명 입력 : ");
			fileName = sc.next();
			os = new FileOutputStream(fileName);
			System.out.println(fileName + "에 저장할 내용입력 : ");
			System.out.println("종료는 exit");
			int lineNumber = 1;
			while (!data.equals("exit"+"\n")) {
				System.out.println(lineNumber++ + " : ");
				byte[] fileData = data.getBytes();
				data = sc.next()+"\n";
				os.write(fileData);
			}

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
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
