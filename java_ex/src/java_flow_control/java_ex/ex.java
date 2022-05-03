package java_ex;

import java.util.Scanner;

public class ex {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		String id=scan.nextLine();
		String pass=scan.nextLine();
		String[][] user= {
				{"a","1"},{"b","2"},{"c","3"}
		};
		
		boolean login=false;
		for(int i=0;i<user.length;i++) {
			String[] idpass=user[i];
			if (
					idpass[0].equals(id)&&idpass[1].equals(pass)
					) {login=true;
					break;}}
			
			if(login){System.out.println("succes");}else{System.out.println("fail");}
				
			
		}
		
	}


