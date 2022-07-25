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
		����: while (true) {
			try {
				System.out.println("1. �����Է�");
				System.out.println("2. �������");
				System.out.println("3. ��������(save)");
				System.out.println("4. �����ҷ�����(load)");
				System.out.println("0. ����");
				System.out.print("�޴� �Է� : ");
				int sel = scan.nextInt();

				switch (sel) {
				case 1:
					System.out.println("������ �Է��մϴ�");
					insert();
					break;
				case 2:
					System.out.println("������ ����մϴ�");
					print();
					break;
				case 3:
					System.out.println("������ �����մϴ�");
					save();
					break;
				case 4:
					System.out.println("������ �ҷ��ɴϴ�");
					load();
					break;
				case 0:
					System.out.println("�����մϴ�");
					break ����;
				default:
					System.out.println("�߸� �Է��ϼ̽��ϴ�");
					break;

				}
			} catch (InputMismatchException e) {
				System.out.println("�߸��� �Է��Դϴ�");
				scan.next();
				continue;
			}
		}

	}

	static void insert() {
		System.out.print("�̸� : ");
		name = scan.next();
		System.out.print("���� : ");
		age = scan.nextInt();
		System.out.print("���� : ");
		job = scan.next();
		scan.nextLine();
		System.out.print("�ּ� : ");
		address = scan.nextLine();

	}

	static void print() {
		System.out.println("�̸� : " + name);
		System.out.println("���� : " + age);
		System.out.println("���� : " + job);
		System.out.println("�ּ� : " + address);
		System.out.println("\n=====================\n");

	}

	static void save() {
		boolean nullCheck = name == null || age == 0 
				|| job == null || address == null ||
				name.isEmpty() || address.isEmpty();
		if (nullCheck == true) {
			System.out.println("������ �����Ҽ� �����ϴ�\n"
					+ "������ ������ �Է����ּ���");
			return;

		} 
		

			System.out.print("������ ���ϸ��� �Է��ϼ��� : ");
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

		System.out.print("�ҷ��� ���ϸ��� �Է��ϼ��� : ");
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
