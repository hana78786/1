package java_ex;

import java.util.Scanner;

public class AuthApp {

	public static void main(String[] args) {
		
		String[][] users= {
				{"elsa","1111"},
				{"anna","2222"},
				{"grogu","3333"}
		};
		
		Scanner scan=new Scanner(System.in);
		System.out.print("id:");
		String inputId=scan.nextLine();
		System.out.print("pass:");
		String inputPass=scan.nextLine();
		
		
		 boolean isLogined=false;
		for(int i=0;i<users.length;i++) {
			String[] current=users[i];
			if(
					current[0].equals(inputId) &&
					current[1].equals(inputPass)
					) {
				isLogined=true;
				break;}
			
		}
		System.out.println("hi");
		if(isLogined) {
			System.out.println("Hello");
		}else {
			System.out.println("error");
		}
		
		scan.close();
	
	}

}
