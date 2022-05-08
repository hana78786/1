package co_te;

public class phone_num1 {
//	프로그래머스 모바일은 개인정보 보호를 위해 고지서를 보낼 때 고객들의 전화번호의 일부를 가립니다.
//	전화번호가 문자열 phone_number로 주어졌을 때, 전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 *으로 가린 문자열을 리턴하는 함수, solution을 완성해주세요.
	

	public static String main(String[] args) {
		String phone_number="12345678910";
	    int i=phone_number.length();
	    String y=	phone_number.substring(0,i-4); //y=01012345
	     int c=y.length();   //c는 phone_number값에서 처음부터 뒤 5자리 값까지의 자리수
	     					// 여기에서는 8
	    String[] e = new String[c];
	    for(int j=0;j<c;j++) {
	    	String d="*";
	    	e[j]=d;
	     }
	     
	String answer=phone_number.replace(y,);   
	System.out.println(answer);
	        return;
	    }
	 
