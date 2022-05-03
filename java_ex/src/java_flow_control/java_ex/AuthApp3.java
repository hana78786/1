package java_ex;

import java.util.Scanner;

public class AuthApp {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.print("id:");
		String inputId=scan.nextLine();
		System.out.print("password:");
		String inputPass=scan.next();
		String id = "egoing";
		String pass= "111111";
		
		scan.close();
		if(inputId.equals(id) && inputPass.equals(pass)) {
			System.out.println("Hello!");
		} else {
			System.out.println("erorr!");
		}

	}

}
