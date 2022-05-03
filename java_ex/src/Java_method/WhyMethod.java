package Java_method;

import java.io.FileWriter;
import java.io.IOException;

public class WhyMethod {
	public static void main(String[] args) throws IOException {
		System.out.println(twoTimes("a", "-"));
	FileWriter fw=new FileWriter("out.txt");
	fw.write(twoTimes("a", "*"));
	fw.close();

		
	
	}
	public static String twoTimes(String text, String delimaiter) {
		String out= "";
		out = out + delimaiter+"\n";
		out= out +text+"\n";
		out=out+text+"\n";
		return out;
		
	}


}
