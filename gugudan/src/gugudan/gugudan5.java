/**
 * 
 */
package gugudan;
import java.util.Scanner;
public class gugudan5 {
	public static void main(String[]args) {
		System.out.println("6단");
		int i=1;
		while(i<10) {
			System.out.println(6*i);
			i=i+1;
		}
		System.out.println("7단");
		for(int c=1;c<10;c++) {
			System.out.println(7*c);
		}
		System.out.println("출력할 단의 숫자를 입력:");
		Scanner scanner = new Scanner(System.in);
		int number=scanner.nextInt();
		System.out.println("number:"+number);
		
	for(int a=1;a<10;a++) {
		System.out.println(number*a);
	}
	}

	
}