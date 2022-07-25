package Ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderEx {
public static void main(String[] args) {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Å×½ºÆ®");
	try {
		String str = br.readLine();
		System.out.println(str);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	public BufferedReaderEx() {
		// TODO Auto-generated constructor stub
	}

}
