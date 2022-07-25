package com.kh.exercise;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class Exercise_IOStream {
	public static void main(String[] args) {
		/*
		 * ������ ���ϸ� �Է� : khtext.txt 'khtext.txt'' ���Ͽ� ����� ���� �Է� : ����� exit 1 : 1111 2 :
		 * text input 3 : good 4 : gogogo 5 : exit ���� ���� �Ϸ� (exit�� �����ϰ� ����)
		 * 
		 */
		OutputStream os = null;
		Scanner sc = new Scanner(System.in);
		String data = "";
		String fileName;

		try {

			System.out.println("������ ���ϸ� �Է� : ");
			fileName = sc.next();
			os = new FileOutputStream(fileName);
			System.out.println(fileName + "�� ������ �����Է� : ");
			System.out.println("����� exit");
			int lineNumber = 1;
			while (!data.equals("exit"+"\n")) {
				System.out.println(lineNumber++ + " : ");
				byte[] fileData = data.getBytes();
				data = sc.next()+"\n";
				os.write(fileData);
			}

			System.out.println("�������� �Ϸ�");

		
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
