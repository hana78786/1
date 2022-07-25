package com.kh.fileclass;

import java.io.File;

import com.kh.exercise.Exam_FileInputStream;

public class Exam_File2 {
	public static void main(String[] args) {
		// 파일경로 알아오기
		
		File inFile = new File("src\\com\\kh\\exercise\\Exam_FileInputStream.java");
		
		System.out.println("파일명 : " + inFile.getName());
		System.out.println("파일용량 : " + inFile.length());
		System.out.println("상위 폴더 : " + inFile.getParent());
		System.out.println("파일경로  : " + inFile.getPath());
		System.out.println("파일경로 : "+ inFile.getAbsolutePath());
	}

}
