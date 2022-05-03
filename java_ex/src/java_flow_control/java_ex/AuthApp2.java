package java_ex;

import java.util.Scanner;

public class AuthApp2 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.print("id:");
		String inputId=scan.nextLine();
		System.out.print("password:");
		String inputPass=scan.next();
		String id = "egoing";
		String pass= "111111";
		String pass2= "222222";
		
		scan.close();
		boolean isRightpass=(inputPass.equals(pass)||inputPass.equals(pass2));
		if(inputId.equals(id) && isRightpass ) {
			System.out.println("Hello!");
		} else {
			System.out.println("erorr!");
		}

	}

}
