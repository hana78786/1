package exersize;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

public class InputOutput {
	static String fileName = "";

	public static void main(String[] args) {
//		fileCreat();
		fileWriter();
//		inputfile();
		cbufRead();
		copyFile();

	}

	public static void copyFile() {
		InputStream is = null;
		OutputStream os = null;

		try {
			is = new FileInputStream(fileName + ".txt");
			os = new FileOutputStream(fileName + "1.txt");
			int data = 0;
			byte[] readByte = new byte[100];
			while ((data = is.read(readByte)) != -1) {
				os.write(readByte,0,data);
			}
			os.flush();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				os.close();
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void cbufRead() {
		Reader reader = null;
		try {
			reader = new FileReader(fileName + ".txt");
			int readNum = 0;
			String data = "";
			char[] readData = new char[5];
			while ((readNum = reader.read(readData)) != -1) {
				data += new String(readData, 0, readNum);
			}
			System.out.print(data);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void inputfile() {
		Reader read = null;

		try {
			read = new FileReader(fileName + ".txt");
			int data = 0;
			while (data != -1) {
				data = read.read();
				System.out.print((char) data);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				read.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void fileWriter() {
		Writer writer = null;

		String fileData = "";
		Scanner scan = new Scanner(System.in);

		try {
			System.out.println("파일이름을 입력하세요");
			fileName = scan.nextLine();
			writer = new FileWriter(fileName + ".txt");
			System.out.println("파일내용을 입력하세요");
			int lineNum = 1;
			while (!fileData.equals("exit\n")) {
				System.out.print(lineNum++ + " ");
				writer.write(fileData);
				fileData = scan.nextLine() + "\n";

			}
			writer.flush();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static void fileCreat() {
		OutputStream os = null;
		String fileName = "";
		String fileData = "";
		Scanner scan = new Scanner(System.in);

		try {
			System.out.println("파일이름을 입력하세요");
			fileName = scan.nextLine();
			os = new FileOutputStream(fileName + ".txt");
			System.out.println("파일내용을 입력하세요");
			int lineNum = 1;
			while (!fileData.equals("exit\n")) {
				System.out.print(lineNum + " ");
				byte[] fileByte = fileData.getBytes();
				fileData = scan.nextLine() + "\n";
				os.write(fileByte);
				lineNum++;
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
