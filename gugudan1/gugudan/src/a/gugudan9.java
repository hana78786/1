package a;
import java.util.Scanner;

public class gugudan9 {
		public static void main(String[] args) {
			System.out.println("구구단의 단 숫자를 입력하세요:");		
			Scanner scanner=new Scanner(System.in);
			int number=scanner.nextInt();
			if (number<2){
				System.out.println("2보다 작은수는 입력할수 없습니다");
			}else if(number>9) {
				System.out.println("9보다 큰 수는 입력할수 없습니다");
			}else {
				System.out.println(number+"단");
				for (int i=1;i<10;i++) {
				System.out.println(number*i);
			}}
					
}}
