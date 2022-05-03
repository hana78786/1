package java_ex;

public class LoopArray {

	public static void main(String[] args) {
		String[] users= new String[3];
		users[0]="egoing";
		users[1]="jinhuck";
		users[2]="youbin";
	
		for(int i=0;i<users.length;i++) {
			if(i+1<users.length) {
			System.out.println("<li>"+users[i]+"</li>");}
			else if(i+1==users.length)
			{System.out.println("<li>"+users[i]+"</li>"+"end");}
		}

	}

}
