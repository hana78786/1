package inputoutputIOS;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

public class FileWrtier {

	


	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int a = 0;
		while (a != 3) {
			System.out.println("1. 파일 저장하기");
			System.out.println("2. 파일불러오기");
			System.out.println("종료 3");
			System.out.print("입력>");
			a = scan.nextInt();
			if (a == 1) {
				save(scan);
			}
			if (a == 2) {
				load(scan);
			}

		}
		scan.close();
		
	}

	private static void load(Scanner scan) {
		Reader reader = null;
		// TODO Auto-generated method stub
		System.out.println("불러올 파일 입력 : ");
		String fileName = scan.next();

		String data = "";
		int readData;
		try {
			reader = new FileReader(fileName + ".txt");
			while (true) {
				readData = reader.read();
				if (readData == -1)
					break;
				data += (char) readData;

			}
			System.out.println(data);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {

				
				reader.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NullPointerException e) {
				e.printStackTrace();
			}

		}
	}

	private static void save(Scanner scan) {
		Writer writer = null;
		// TODO Auto-generated method stub
		System.out.println("파일을 저장합니다");
		System.out.println("끝을 입력하면 저장종료");
		System.out.print("파일이름을 입력하세요 : ");

		String fileName = scan.next();

		String data = "";
		int LineNum = 0;
		scan.nextLine();
		try {
			writer = new FileWriter(fileName + ".txt");
			while (true) {
				System.out.print(++LineNum + " : ");
				data = scan.nextLine();
				if (data.equals("끝"))
					break;
				writer.write(data);
				data = "\n";
				writer.write(data);
			}
			writer.flush();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {

				writer.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NullPointerException e) {
				e.printStackTrace();
			}

		}

	}
}
