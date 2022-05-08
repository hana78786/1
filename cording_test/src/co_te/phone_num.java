package co_te;

public class phone_num {
//	프로그래머스 모바일은 개인정보 보호를 위해 고지서를 보낼 때 고객들의 전화번호의 일부를 가립니다.
//	전화번호가 문자열 phone_number로 주어졌을 때, 전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 *으로 가린 문자열을 리턴하는 함수, solution을 완성해주세요.
	
	
	public phone_num() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
	String number = "01027143368";
	StringBuffer ab= new StringBuffer(number);
	ab.replace(1, 16, "[0-9]");
	System.out.println(ab);
		
	int i=number.length();
	number.substring(1,i-4);
	System.out.println(number.substring(0,i-4));
String y = number.substring(0,i-4);
int c=y.length();

String d = null;
 for(int j=0;j<c;j++) {
	d="*";};
	System.out.println(d);
String t=number.replace(y,d);

System.out.println(t);

	}

}
