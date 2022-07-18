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
					insert(scan);
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
					load(scan);
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
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("해당파일이 없습니다");
				e.printStackTrace();
			}
		}

	}

	private static void load(Scanner scan) throws FileNotFoundException {
		System.out.print("불러올 회원명을 입력하세요 : ");
		String file = scan.next();
		
		
		//목표 파일을 불러와서 출력하기
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
		System.out.println("불러오기 완료!");
		
		
		

	}

	private static void save() {
		if (name == null && age == 0 && address == null) {
			System.out.println("저장불가 데이터를 입력하세요");
		} else {
			
			try {
				writer = new FileWriter(name+".txt");
				StringBuffer sb= new StringBuffer(name).append("/").append(age).append("/").append(address);
				System.out.println(sb);
				String a = new String(sb);
				writer.write(a);
				writer.flush();
				

				//목표 파일을 저장하기
				
				
				
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
	
			
			
			
		}

	}

	private static void print() {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("주소 : " + address);
		System.out.println("출력종료");

	}

	private static void insert(Scanner scan) {
		System.out.println("정보를 입력합니다");
		System.out.print("이름 :");
		name = scan.next();
		System.out.print("나이 : ");
		age = scan.nextInt();
		System.out.println("주소 : ");
		scan.nextLine();
		address = scan.nextLine();

		System.out.println("입력종료");

	}

}
