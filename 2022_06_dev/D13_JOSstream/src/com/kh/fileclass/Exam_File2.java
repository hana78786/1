package com.kh.fileclass;

import java.io.File;

import com.kh.exercise.Exam_FileInputStream;

public class Exam_File2 {
	public static void main(String[] args) {
		// ���ϰ�� �˾ƿ���
		
		File inFile = new File("src\\com\\kh\\exercise\\Exam_FileInputStream.java");
		
		System.out.println("���ϸ� : " + inFile.getName());
		System.out.println("���Ͽ뷮 : " + inFile.length());
		System.out.println("���� ���� : " + inFile.getParent());
		System.out.println("���ϰ��  : " + inFile.getPath());
		System.out.println("���ϰ�� : "+ inFile.getAbsolutePath());
	}

}
