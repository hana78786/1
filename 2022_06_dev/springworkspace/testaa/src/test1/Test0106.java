package test1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Test0106 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;

		String a = br.readLine();
		String result = "";
		for (int i = 0; i < Integer.parseInt(a); i++) {
			String one = br.readLine();
			st = new StringTokenizer(one);
			bw.write((Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken())) + "\n");

		}
		bw.flush();
	}
}