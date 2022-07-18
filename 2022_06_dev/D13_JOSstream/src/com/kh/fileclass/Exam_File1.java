package com.kh.fileclass;

import java.io.File;
import java.io.IOException;

public class Exam_File1 {
	public static void main(String[] args) {
		//File - 파일생성, 폴더생성, 파일존재여부 확인, 파일여부 확인 할수있는 메소드!
		//FileOutputStream > write() 파일에 내용 쓰기
		
		makeFile();
		MakeDirectory();
		makeFileInDirectory();
		
		
		
		
		
		
		
	}//main

	 static void makeFileInDirectory() {
		// TODO Auto-generated method stub
		 File file = new File("D:\\khfile\\khtext.txt");
		 try {
			file.createNewFile();
			System.out.println("파일이 존재하는가? : "+file.exists());
			System.out.println("khtext파일이 맞는가? : "+file.isFile());
			//파일삭제 
			if(file.delete())System.out.println("파일이 삭제되었습니다.");
			System.out.println("파일이 존재하는가? : " + file.exists());
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
		 System.out.println("khfile3 폴더가 맞는가? : " +!file.isFile());
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
