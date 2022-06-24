package com.kh.javaapi;

public class Exam_StringBuffer {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		sb.append("Hello");
		sb.append("");
		sb.append("java");

		System.out.println("연결된 문자열 : " + sb.toString());
		String result = "Hello" + " " + "java";
		System.out.println("+로 연결된 문자열: " + result);
		
		StringBuffer stb = new StringBuffer().append("KH").append(" Java class").append(" Good");
		System.out.println(stb.toString());
		System.out.println(stb.substring(14));
		stb.delete(14, 17);
		System.out.println(stb.toString());
	}
}
