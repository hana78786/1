package inputoutputIOS;

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
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class IOStream {
	static String name;
	static int age;
	static String address;
	static InputStream is = null;
	static OutputStream os = null;
	static Writer writer = null;
	static Reader reader = null;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		menu(scan);
	}

	static void menu(Scanner scan) {
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
					insert(scan);
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
					load(scan);
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
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("�ش������� �����ϴ�");
				e.printStackTrace();
			}
		}

	}

	private static void load(Scanner scan) throws FileNotFoundException {
		System.out.print("�ҷ��� ȸ������ �Է��ϼ��� : ");
		String file = scan.next();
		
		
		//��ǥ ������ �ҷ��ͼ� ����ϱ�
		is = new FileInputStream(file+".txt");
		int readData;
		String data="";
		while(true) {
			try {
				byte[]b= new byte[100];
				
				
				readData = is.read(b);
				if(readData==-1) {
					break;
				}
				data +=new String(b,0,readData);
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		StringTokenizer st = new StringTokenizer(data,"/");
		name = st.nextToken();
		age = Integer.parseInt(st.nextToken());
		address= st.nextToken();
		System.out.println("�ҷ����� �Ϸ�!");
		
		
		

	}

	private static void save() {
		if (name == null && age == 0 && address == null) {
			System.out.println("����Ұ� �����͸� �Է��ϼ���");
		} else {
			
			try {
				writer = new FileWriter(name+".txt");
				StringBuffer sb= new StringBuffer(name).append("/").append(age).append("/").append(address);
				System.out.println(sb);
				String a = new String(sb);
				writer.write(a);
				writer.flush();
				

				//��ǥ ������ �����ϱ�
				
				
				
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
	
			
			
			
		}

	}

	private static void print() {
		System.out.println("�̸� : " + name);
		System.out.println("���� : " + age);
		System.out.println("�ּ� : " + address);
		System.out.println("�������");

	}

	private static void insert(Scanner scan) {
		System.out.println("������ �Է��մϴ�");
		System.out.print("�̸� :");
		name = scan.next();
		System.out.print("���� : ");
		age = scan.nextInt();
		System.out.println("�ּ� : ");
		scan.nextLine();
		address = scan.nextLine();

		System.out.println("�Է�����");

	}

}
