package co_te;

public class phone_num1 {
//	프로그래머스 모바일은 개인정보 보호를 위해 고지서를 보낼 때 고객들의 전화번호의 일부를 가립니다.
//	전화번호가 문자열 phone_number로 주어졌을 때, 전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 *으로 가린 문자열을 리턴하는 함수, solution을 완성해주세요.
	

	public static void main(String[] args) {
		String phone_number="01012345678";
		int i=phone_number.length();
	       String y=	phone_number.substring(0,i-4); 
	        int c=y.length();   
	        String d = "";
	       d(c, d);
	   String t=phone_number.replace(y,d);   
	   System.out.print(t);
	       }
	
	      public static String d(int c, String d) {
	   		for(int j=0;j<c;j++) {
	   			d="*";
	   			System.out.print(d);
	   		};
	   		return d;
	   	} 
	   }

