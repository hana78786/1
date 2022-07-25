package com.kh.exersice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Exercise_IOStream {
	static String name;
	static int age;
	static String job;
	static String address;
	static Scanner scan = new Scanner(System.in);
	static InputStream is = null;
	static OutputStream os = null;
	static Writer writer = null;
	static Reader reader = null;
	static BufferedReader brReader = null;

	public static void main(String[] args) {

		menu();
	}

	static void menu() {
		종료: while (true) {
			try {
				System.out.println("1. 정보입력");
				System.out.println("2. 정보출력");
				System.out.println("3. 정보저장(save)");
				System.out.println("4. 정보불러오기(load)");
				System.out.println("0. 종료");
				System.out.print("메뉴 입력 : ");
				int sel = scan.nextInt();

				switch (sel) {
				case 1:
					System.out.println("정보를 입력합니다");
					insert();
					break;
				case 2:
					System.out.println("정보를 출력합니다");
					print();
					break;
				case 3:
					System.out.println("정보를 저장합니다");
					save();
					break;
				case 4:
					System.out.println("정보를 불러옵니다");
					load();
					break;
				case 0:
					System.out.println("종료합니다");
					break 종료;
				default:
					System.out.println("잘못 입력하셨습니다");
					break;

				}
			} catch (InputMismatchException e) {
				System.out.println("잘못된 입력입니다");
				scan.next();
				continue;
			}
		}

	}

	static void insert() {
		System.out.print("이름 : ");
		name = scan.next();
		System.out.print("나이 : ");
		age = scan.nextInt();
		System.out.print("직업 : ");
		job = scan.next();
		scan.nextLine();
		System.out.print("주소 : ");
		address = scan.nextLine();

	}

	static void print() {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("직업 : " + job);
		System.out.println("주소 : " + address);
		System.out.println("\n=====================\n");

	}

	static void save() {
		boolean nullCheck = name == null || age == 0 
				|| job == null || address == null ||
				name.isEmpty() || address.isEmpty();
		if (nullCheck == true) {
			System.out.println("파일을 저장할수 없습니다\n"
					+ "저장할 내용을 입력해주세요");
			return;

		} 
		

			System.out.print("저장할 파일명을 입력하세요 : ");
			String file = scan.next();
			try {

				writer = new FileWriter(file + ".txt");
				writer.write(name + "/");
				writer.write(age + "/");
				writer.write(job + "/");
				writer.write(address + "/");
				writer.flush();

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

	static void load() {

		System.out.print("불러올 파일명을 입력하세요 : ");
		String file = scan.next();
		String readStr = "";

		try {
			reader = new FileReader(file + ".txt");
			brReader= new BufferedReader(reader);
			readStr= brReader.readLine();
			

			StringTokenizer st = new StringTokenizer(readStr, "/");
			name = st.nextToken();
			age = Integer.parseInt(st.nextToken());
			job = st.nextToken();
			address = st.nextToken();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
