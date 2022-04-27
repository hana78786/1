package a;

import java.util.Scanner; //입력받기 위해서는 미리 표기해야한다

public class gugudan8 {
	public static void main(String[]args) {
		System.out.println("출력할 구구단의 단수를 입력하세요 2~9:");
		Scanner scanner1=new Scanner(System.in); 
 //scanner1을 새로운것으로 입력받는다(system.in)
		int number1= scanner1.nextInt();   
//number1으로 정의한다 스캔1을 지금받은 값으로
		if(number1<2) { 
 //첫번째 스캔받은 코드가 2보다 작을때
			System.out.println("2이상의 수를 입력하세요");  
 //오류메세지
		}else if(number1>9) { 
 //그렇지 않을때 9보다 크다면
			System.out.println("9보다 클수 없습니다");} //오류메세지
		else{ 
 //그렇지 않을때 다음 코드를 이행한다
		System.out.println("곱할값을 입력하세요 1~9:");
		Scanner scanner2=new Scanner(System.in);
//값을 scanner2로 입력받는다
		int number2= scanner2.nextInt();
 //scanner2를 number2로 정의하였다
		if(number2<1) { 
//입력값이 1보다 작을때
			System.out.println("1이상의 수를 입력하세요");  //오류메세지
		}else if(number2>9) { 
//9보다 클때
			System.out.println("9보다 클수 없습니다");} //오류메세지
		else{
 //둘다 아닐때 아래 코드를 실행한다
		System.out.println(number1+"X"+number2);
		System.out.println("="+number1*number2);
	}}}
}
