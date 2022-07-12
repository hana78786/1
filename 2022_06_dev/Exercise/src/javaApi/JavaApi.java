package javaApi;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class JavaApi {
	public static void main(String[] args) {

		String data = " 우영우 재밌따 ";
		String data1 = " 공부 합시다! ";
		String data2 = " 자바도 재밌어 ";

//		문자 글자 세기
		System.out.println("data1의 문자수 :");
		
		System.out.println(data1.length());
		
		
		
		
		System.out.println();
//		글자 속에 문자 하나 찾기
		System.out.println("우 문자열 찾기");
		
		System.out.println(data.contains("우"));
		
	
		
		

		System.out.println();
//		문자 연결하기
		System.out.println("문자 연결하기");
		
		System.out.println(data1.concat(data2));

		
		
		System.out.println();
//		공백제거하기
		System.out.println("앞뒤 공백제거하기 가운데는 제거 안해줌");
		
		System.out.println(data.trim());
		
		
		
		

		System.out.println();
		// 문자 변경하기
		System.out.println("문자 변경하기 우영우 -> 드라마");
		
		System.out.println(data.replace("우영우", "드라마"));
		
		
		

		System.out.println();

//		문자열 분리하기 배열로
		System.out.println("배열로 만들기");
		
		String data3[] = data1.split(" ");
		System.out.println(data3[1]);
		
		
		

		System.out.println();

//		문자열분리하기 Stirng으로
		System.out.println("string사용하여 문자열 분리하기");
		
		StringTokenizer st = new StringTokenizer(data1," ");
		System.out.println(st.nextToken());
		
		

		
		
		

		System.out.println();

//		String으로 자른 문자열 더 있는지 확인
		System.out.println("자른 문자열이 더 있어?");
		
		System.out.println(st.hasMoreTokens());
		
		

		
		
		

		System.out.println();
//		문자열을 잘라 문자 1개로 만들기
		System.out.println("네번째 문자만 잘라둘거야");
		
		System.out.println(data.charAt(3));
		
		
		

		
		System.out.println();
//		문자 더하기
		System.out.println("문자열 더하기 ");
		
		StringBuffer sb = new StringBuffer(data2);
		System.out.println(sb.append(data1).append("^^").append("!!"));
		
		
		
		

		System.out.println();
//		날짜 만들기
		System.out.println("지금이 언제야?");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM");
		Date date = new Date();
		System.out.println(date);
		System.out.println(sdf.format(date));
		
		
		
	

		System.out.println();
	}

}
