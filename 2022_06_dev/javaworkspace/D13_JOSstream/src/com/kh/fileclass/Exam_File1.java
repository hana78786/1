package com.kh.fileclass;

import java.io.File;
import java.io.IOException;

public class Exam_File1 {
	public static void main(String[] args) {
		//File - ���ϻ���, ��������, �������翩�� Ȯ��, ���Ͽ��� Ȯ�� �Ҽ��ִ� �޼ҵ�!
		//FileOutputStream > write() ���Ͽ� ���� ����
		
		makeFile();
		MakeDirectory();
		makeFileInDirectory();
		
		
		
		
		
		
		
	}//main

	 static void makeFileInDirectory() {
		// TODO Auto-generated method stub
		 File file = new File("D:\\khfile\\khtext.txt");
		 try {
			file.createNewFile();
			System.out.println("������ �����ϴ°�? : "+file.exists());
			System.out.println("khtext������ �´°�? : "+file.isFile());
			//���ϻ��� 
			if(file.delete())System.out.println("������ �����Ǿ����ϴ�.");
			System.out.println("������ �����ϴ°�? : " + file.exists());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		
	}

	static void MakeDirectory() {
		// TODO Auto-generated method stub
		 File file = new File("D:\\khfile\\khfile2\\khfile3");
//		 file.mkdir();
		 file.mkdirs();
		 System.out.println("khfile3 ������ �´°�? : " +!file.isFile());
	}

	static void makeFile() {
		// TODO Auto-generated method stub
		 File file = new File("khfile.txt");
		 try {
			 file.createNewFile();
		 } catch (IOException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
		 }//catch
		 
		
	}

}//class
