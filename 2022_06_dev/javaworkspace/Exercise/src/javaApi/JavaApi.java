package javaApi;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class JavaApi {
	public static void main(String[] args) {

		String data = " �쿵�� ��յ� ";
		String data1 = " ���� �սô�! ";
		String data2 = " �ڹٵ� ��վ� ";

//		���� ���� ����
		System.out.println("data1�� ���ڼ� :");
		
		System.out.println(data1.length());
		
		
		
		
		System.out.println();
//		���� �ӿ� ���� �ϳ� ã��
		System.out.println("�� ���ڿ� ã��");
		
		System.out.println(data.contains("��"));
		
	
		
		

		System.out.println();
//		���� �����ϱ�
		System.out.println("���� �����ϱ�");
		
		System.out.println(data1.concat(data2));

		
		
		System.out.println();
//		���������ϱ�
		System.out.println("�յ� ���������ϱ� ����� ���� ������");
		
		System.out.println(data.trim());
		
		
		
		

		System.out.println();
		// ���� �����ϱ�
		System.out.println("���� �����ϱ� �쿵�� -> ���");
		
		System.out.println(data.replace("�쿵��", "���"));
		
		
		

		System.out.println();

//		���ڿ� �и��ϱ� �迭��
		System.out.println("�迭�� �����");
		
		String data3[] = data1.split(" ");
		System.out.println(data3[1]);
		
		
		

		System.out.println();

//		���ڿ��и��ϱ� Stirng����
		System.out.println("string����Ͽ� ���ڿ� �и��ϱ�");
		
		StringTokenizer st = new StringTokenizer(data1," ");
		System.out.println(st.nextToken());
		
		

		
		
		

		System.out.println();

//		String���� �ڸ� ���ڿ� �� �ִ��� Ȯ��
		System.out.println("�ڸ� ���ڿ��� �� �־�?");
		
		System.out.println(st.hasMoreTokens());
		
		

		
		
		

		System.out.println();
//		���ڿ��� �߶� ���� 1���� �����
		System.out.println("�׹�° ���ڸ� �߶�Ѱž�");
		
		System.out.println(data.charAt(3));
		
		
		

		
		System.out.println();
//		���� ���ϱ�
		System.out.println("���ڿ� ���ϱ� ");
		
		StringBuffer sb = new StringBuffer(data2);
		System.out.println(sb.append(data1).append("^^").append("!!"));
		
		
		
		

		System.out.println();
//		��¥ �����
		System.out.println("������ ������?");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM");
		Date date = new Date();
		System.out.println(date);
		System.out.println(sdf.format(date));
		
		
		
	

		System.out.println();
	}

}
