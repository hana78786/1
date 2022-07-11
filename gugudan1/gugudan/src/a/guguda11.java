package a;
import java.util.Scanner;
public class guguda11 {
	public static void main(String[]args) {
		System.out.println("숫자를 입력하면 2부터 입력한수의 숫자단이 출력됩니다");
//입력시 어떤 숫자를 입력해야 할지 안내 메세지
		Scanner s1=new Scanner(System.in);
//입력한 숫자를  s1이라는 수로 정의한다.
		int no1=s1.nextInt();
//no1의 값을 입력받은 s1으로 정의한다
		for(int i=2;i<no1+1;i++) {
			for(int j=1;j<no1+1;j++)

			System.out.println(i+"x"+j+"="+j*i);

		}
	
}}
