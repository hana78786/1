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
		 * ������ ���ϸ� �Է� : khtext.txt 'khtext.txt'' ���Ͽ� ����� ���� �Է� : ����� exit 1 : 1111 2 :
		 * text input 3 : good 4 : gogogo 5 : exit ���� ���� �Ϸ� (exit�� �����ϰ� ����)
		 * 
		 */
		Scanner sc = new Scanner(System.in);
		String data = "";
		String fileName;
		Writer writer = null;

		try {
			System.out.println("������ ���ϸ� �Է� : ");
			fileName = sc.next();	
			
			writer = new FileWriter(fileName);	//��Ʈ���� ����
			
			System.out.println(fileName+"�� ����� ���� �Է�");
			System.out.println("����� exit");
			
			
			int lineNumber = 1;
			
			
			while (!data.equals("exit\n")) {
				System.out.println(lineNumber++ + " : ");
				writer.write(data);
				data = sc.next()+"\n";
					
			}
			writer.flush(); //��Ʈ���� ����� ���⸦ �Ϸ�
			System.out.println("���� �Ϸ�");	//�ܼ� ��¿�
			


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
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
