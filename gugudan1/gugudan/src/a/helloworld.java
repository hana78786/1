package a;
import java.util.Scanner;

public class helloworld {
	public static void main(String[] args) {
		System.out.println("원하는 단을 입력하세요");
		Scanner s=new Scanner(System.in);
		int no=s.nextInt();
		for(int i=1;i<10;i++) {
			System.out.println(no+"x"+i+"="+i*no);
		}
	}
	}

