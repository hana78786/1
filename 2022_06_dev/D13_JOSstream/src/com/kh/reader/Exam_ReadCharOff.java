package com.kh.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Exam_ReadCharOff {
	public static void main(String[] args) {
		Reader reader = null;
		//Reader  reader = new FileReader("filereader.txt");
		//��� �ѹ��� �������� �ʴ� ������  Reader�� ����ó���� �ʿ��ϱ⶧���� trycatch�� ����
		//finally���� reader�� �ݾ��ַ��� reader�� �������������ϴµ� try�ȿ� ���� �����������ȴ�.
		//�׷��� �Ϻη� reder�� ���� �����Ѵ�.
		

		try {

			reader = new FileReader("filereader.txt");
			int readCharNo; // �̻�� ����
			char[] cbuf = new char[4];
			readCharNo = reader.read(cbuf, 0, 3);
			//�迭�� �ʱ�ȭ �����ش�.
			for (int i = 0; i < cbuf.length; i++) {
				System.out.println(cbuf[i]);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {

				reader.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
