package com.kh.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Exam_ReadChar {
	public static void main(String[] args) {
		Reader reader = null; // ���ڱ�� ��Ʈ���� ��Ʈ�Ľ�ȭ �ߴ�
		try {
			reader = new FileReader("filereader.txt");
			int readCharNo; 
			char[] cbuf = new char[2];
			String data = "";
			while ((readCharNo = reader.read(cbuf)) != -1) {
					// readCharNo = cbuf�� ���� �����̴�. 
					//cbuf�� �迭�� 2�̱⶧���� ���ڸ� 2���� �д´�.
					//�����̸� 0�� �д´�
					//���� ������ -1�� �д´�.
					//-1�� ������ �ݺ��� ����ȴ�.
				data += new String(cbuf, 0, readCharNo); 
				// ���ڹ迭�� ���ڸ� ���ڷ� �ٲٴ� ����
				// new String(byte[] bytes, int offset, int length);
				// new String(����Ʈ�迭, ���� �ε��� ���� �ٵ� �� �ٸ����ڸ� ������ �ȵ���? , ������ ũ��);
				 
			}
			System.out.println(data);
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
