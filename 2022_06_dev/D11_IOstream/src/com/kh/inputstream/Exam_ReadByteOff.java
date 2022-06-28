package com.kh.inputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Exam_ReadByteOff {
	public static void main(String args[]) {
		InputStream is = null;
		Scanner sc= new Scanner(System.in);
		try {
			is = new FileInputStream("inputStream.txt");
			int readByteNo;
			byte[] readBytes = new byte[8];
			readByteNo=is.read(readBytes, 2,3);
			for(int i = 0; i< readBytes.length;i++) {
				System.out.println((char)readBytes[i]);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				is.close();
				sc.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
