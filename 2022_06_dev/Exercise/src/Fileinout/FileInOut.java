package Fileinout;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileInOut {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		Scanner scan = new Scanner(System.in);
		Writer writer = null;
		Reader reader = null;
		
		System.out.println("파일이름 :");
		String file = scan.next();
		try {
			writer = new FileWriter(file+".txt");
			System.out.println("이름");
			String name = scan.next();
			System.out.println("나이");
			int age = scan.nextInt();
			scan.nextLine();
			System.out.println("주소");
			String address = scan.nextLine();
			
			writer.write(name+"/"+age+"/"+address);
			writer.flush();
			
			System.out.println("파일로드");
			reader = new FileReader(file+".txt");
			BufferedReader bfr = new BufferedReader(reader);
			String str = bfr.readLine();
			StringTokenizer st = new StringTokenizer(str,"/");
			String name1 = st.nextToken();
			int age1 = Integer.parseInt(st.nextToken());
			String address1 = st.nextToken();
			
			System.out.println(age1+name1+address1);
			
			
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
}