package a;
import java.util.Scanner;
public class gugudan10 {
	public static void main(String[]args) {
		System.out.println("입력한 숫자를 구구단 중 최종 단으로 인식해 출력합니다 a,b값으로 입력하세요");
		Scanner s1=new Scanner(System.in);
		String inputValue=s1.nextLine();
		String[] splitedValue=inputValue.split(",");
		int first=Integer.parseInt(splitedValue[0]);
		int second=Integer.parseInt(splitedValue[1]);

		for(int i=2;i<first+1;i++) {
			for(int j=1;j<second+1;j++) {System.out.println(i+"x"+j+"="+i*j);}
			
		}
	
}}