package make.topokki;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Topoki_Client {

	static int money = 1000;
	static int gameMoney = 0;
	static String Ox;
	static String[] quizNum = new String[10];
	static boolean[] quizAnswer = new boolean[10];
	static int answer = 0;
	static Random random = new Random();
	static Scanner scan = new Scanner(System.in);
	static boolean topoki = false;
	static Nembi_Store ns = new Nembi_Store();
	static boolean noMoney = false;

	public static void main(String[] args) {

		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		int port = 8889;
		String address = "127.0.0.1";
		String ansOx = "";
		boolean game = false;
		int count = 0;
		int gameMoney = 0;

		try {
			System.out.println("서버와 연결합니다.");
			socket = new Socket(address, port);
			System.out.println("서버와 연결되었습니다.");
			is = socket.getInputStream();
			os = socket.getOutputStream();
			dis = new DataInputStream(is);
			dos = new DataOutputStream(os);
			System.out.println("게임을 시작합니다");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 게임시작
		try {
			System.out.println("====================================");
			System.out.println("배고프다....");
			Thread.sleep(200);
			System.out.println("떡볶이 먹고싶다...");
			Thread.sleep(200);
			System.out.println("그치만 지갑엔 1000원 뿐..");
			System.out.println("앗 저게 뭐지?!");
			Thread.sleep(500);
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠛⠉⠉⠉⠙⠛⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
			Thread.sleep(150);
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠃⠀⠀⣠⣶⣶⡄⠀⠀⠙⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
			Thread.sleep(150);
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⠀⠀⠀⠟⠀⣹⣿⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿");
			Thread.sleep(150);
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⡀⠀⠀⠀⠀⢸⡏⠁⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿");
			Thread.sleep(150);
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⠀⠀⠀⠀⢸⡦⠀⠀⠀⢀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿");
			Thread.sleep(150);
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢱⣶⣶⣶⣶⢶⣶⣶⣶⡎⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
			Thread.sleep(150);
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢸⣿⣿⡛⠋⠈⠛⣻⣿⡇⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
			Thread.sleep(150);
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢸⣿⣿⣿⢀⣀⢸⣿⣿⡇⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
			Thread.sleep(150);
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢸⣿⣿⣿⣿⣿⣿⣿⣿⡇⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
			Thread.sleep(150);
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⡇⡶⣦⣤⣤⣤⣤⣤⣤⣤⣤⣤⣴⡎⣿⣿⣿⣿⣿⣿⣿⣿");
			Thread.sleep(150);
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣷⢲⡖⠀⠀⠀⠒⠀⠒⢦⣤⣤⡄⣾⣿⣿⣿⣿⣿⣿⣿⣿");
			Thread.sleep(150);
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⡏⣿⠀⠀⠀⢤⠀⠀⡤⠀⠀⠈⣿⢹⣿⣿⣿⣿⣿⣿⣿⣿");
			Thread.sleep(150);
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⠁⠃⠀⠀⠐⠂⠀⠀⠐⠀⠀⠀⠉⠈⣿⣿⣿⣿⣿⣿⣿⣿");
			Thread.sleep(150);
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣀⡀⠀⠀⠀⠀⠀⠀⡀⠀⠀⠀⢀⣀⣿⣿⣿⣿⣿⣿⣿⣿");
			Thread.sleep(150);
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⡀⠀⠀⠀⠙⠖⠃⠀⠀⢠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿");
			Thread.sleep(150);
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢫⣤⣄⡀⠀⠀⣀⢤⣴⣮⡻⣿⣿⣿⣿⣿⣿⣿⣿⣿");
			Thread.sleep(150);
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⢣⣿⣿⣷⡶⠥⠭⣤⣴⣿⣿⣷⡹⣿⣿⣿⣿⣿⣿⣿⣿");
			Thread.sleep(150);
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⢇⣿⣿⣿⣿⣧⠀⠀⣾⣿⣿⣿⣿⣧⢻⣿⣿⣿⣿⣿⣿⣿");
			Thread.sleep(150);
			System.out.println("⣿⣿⣿⣿⣿⣿⠿⠟⢸⣿⣿⣿⣿⣿⠀⢰⣿⣿⣿⣿⣿⣿⡜⣿⣿⣿⣿⣿⣿⣿");
			Thread.sleep(150);
			System.out.println("⣿⣿⣿⣿⡟⠁⠀⠀⠀⠉⠻⠿⣿⣿⣇⣼⣿⣿⣿⣿⣿⣿⡇⣿⣿⣿⣿⣿⣿⣿");
			Thread.sleep(150);
			System.out.println("⣿⣿⣿⡿⠛⠂⠰⠿⠿⠿⠆⠖⠛⠛⠛⠛⠛⠿⠻⠿⠛⠟⠇⠛⠛⠻⣿⣿⣿⣿");
			Thread.sleep(150);
			System.out.println("⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿");
			Thread.sleep(150);
			System.out.println("⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿");
			Thread.sleep(150);
			System.out.println("⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿");
			Thread.sleep(150);
			System.out.println("⣿⣿⣿⣧⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣿⣿⣿⣿");
			Thread.sleep(150);
			System.out.println("[퀴즈대회!! 퀴즈를 모두 맞추시면 상금을 드립니다!]");
			System.out.println("도전해볼까...?");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		종료: while (true) {
			if(money<=0 && (ns.tock==0 || ns.dangmen ==0 || ns.dashida==0 
					|| ns.egg ==0 || ns.odeng==0 || ns.gochujang==0)) {
				try {
				Thread.sleep(200);
				System.out.println("=========");
				System.out.println("돈을 전부 잃었습니다..");
				System.out.println("게임오버......");				
				System.out.println("");
				Thread.sleep(200);
				System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⡟⠍⠓⠀⠀⠀⠀⠊⠝⡻⣿⣿");
				Thread.sleep(200);
				System.out.println("⣿⣿⣿⣿⠿⢿⣿⣿⣿⣿⣿⡿⢿⣿⣿⣿⢟⠊⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢚⢿");
				Thread.sleep(200);
				System.out.println("⣿⣿⣿⡏⠂⠑⠿⣿⣿⣿⡫⠊⠠⢻⣿⡟⠂⠀⡠⢔⢒⣀⣌⣉⣐⣒⢢⡀⠀⠞");
				Thread.sleep(200);
				System.out.println("⣿⣿⡿⡉⠀⠀⠈⠉⠉⠉⠀⠀⠀⢚⣿⡇⠀⢠⠃⠉⠛⠛⠛⠛⠛⠛⠀⢣⠀⠀");
				Thread.sleep(200);
				System.out.println("⣿⣿⡙⠀⠀⢀⡀⠀⠀⢀⡀⠀⠀⠀⠪⢧⠆⠘⠒⠤⠤⢄⣀⣀⡤⠤⠔⠊⠀⢦");
				Thread.sleep(200);
				System.out.println("⣿⣧⠀⠐⠒⠉⠀⠀⠀⠀⠉⠊⠀⠀⡀⢉⣯⢀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⢬⣾");
				Thread.sleep(200);
				System.out.println("⣿⣸⠉⠀⠀⠈⠁⡀⠀⠈⠁⢀⣀⠀⠀⢸⠛⡣⠁⠀⠀⢀⣀⡀⠠⣄⣢⣷⣿⣿");
				Thread.sleep(200);
				System.out.println("⣿⣊⡖⠀⠀⠀⠀⣀⠀⠀⠀⡎⠀⠀⢀⡦⣀⢜⣮⣬⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿");
				Thread.sleep(200);
				System.out.println("⣿⣷⣶⣴⣠⠄⠀⢀⣀⣀⣀⣤⡴⠞⠈⢜⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
				Thread.sleep(200);
				System.out.println("⣿⣿⣿⡿⠟⣿⣿⡀⠉⠉⠉⠀⢀⠀⠀⠀⢈⢟⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
				Thread.sleep(200);
				System.out.println("⣿⣏⣁⠄⢰⣿⣿⠃⠀⢰⠀⠀⢸⣀⣀⣀⠀⠀⠑⡹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
				Thread.sleep(200);
				System.out.println("⣿⣿⣿⣤⣤⣤⣿⡰⠣⡘⡄⠀⣼⠁⠀⠀⠀⠀⠀⢠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
				Thread.sleep(200);
				System.out.println("⣿⣿⡟⠁⠒⠃⢨⣧⠆⠈⢇⠀⡾⡀⠀⠀⠀⠀⠈⠸⠛⠛⠛⠛⠻⠿⢻⣿⣿⣿");
				Thread.sleep(200);
				System.out.println("⣿⣿⣧⣰⣷⣶⣾⣯⣪⠤⠋⠀⠏⠄⠀⠀⠠⢤⣄⣀⣀⣀⣀⣂⣐⣦⣾⣿⣿⣿");
				Thread.sleep(200);
				dos.writeInt(9999);//게임 종료코드 전송
				break 종료;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			try {
				System.out.println("====================");
				System.out.println();

				System.out.println("1. 퀴즈대회에 도전한다");
				System.out.println("2. 소지금을 확인한다");
				System.out.println("3. 냄비를 본다");
				System.out.println("4. 상점에 간다");
				System.out.println("5. 게임을 종료한다.");
				System.out.print(">>");
				int sel = scan.nextInt();
				switch (sel) {
				case 1:
					// 퀴즈대회 매뉴
					game = false;
					count = 0;
					System.out.println("==================");
					System.out.println("퀴즈게임!!");

					while (true) {

						Thread.sleep(300);
						System.out.println("퀴즈는 총 3문제");
						Thread.sleep(300);
						System.out.println("ox를 맞추시면 참가비에 3배를 받습니다!");
						System.out.println("참가 하시겠습니까?");
						Thread.sleep(300);
						System.out.print("ox를 입력하세요 >>");
						Ox = scan.next();

						/// 게임참가를 묻는다
						if (Ox.equalsIgnoreCase("o")) {
							System.out.println("퀴즈 게임을 시작합니다!!");
							Thread.sleep(300);
							System.out.println("==================");

							// 퀴즈게임//

							while (count!=3) {

								int[] ranArr = new int[3]; // 번도 3개 저장할 배열

								System.out.println("참가비를 입력해주세요 :");
								gameMoney = scan.nextInt();
								
								//참가금 부족할때코드//
								if (gameMoney > money) {
									System.out.println("돈이 부족합니다.");
									noMoney = true; //참가금 부족 변수 참
									
									break;//와일문 탈출
								}//부족코드 종료
								else if(gameMoney<1) {//금액을 1보다 작게 입력하면 게임불가
									System.out.println("금액을 잘못입력하셨습니다");
									noMoney = true;
									break;
									
								}
								
								//참가금이 충분할때는 게임 진행//
								System.out.println("=======================");
								
								
								//문제를 랜덤으로 뽑기 시작//
								for (int i = 0; i < 3; i++) {// 중복 방지 코드
									ranArr[i] = random.nextInt(10);
									for (int j = 0; j < i; j++) {
										if (ranArr[i] == ranArr[j]) {
											i--;
										}
									}
								}
								///////// 문제 랜덤뽑기 종료//////
								
								//////////////문제 3개 출력시작////////////
								for (int a = 0; a < 3; a++) {
									System.out.println((a + 1) + "번 문제 :");

									//랜덤번호 결과값 보낼 준비
									int i = ranArr[a];
									dos.writeInt(i);
									///// 랜덤으로 뽑은 번호 전송///

									String quiz = dis.readUTF();
									/// 랜덤으로 뽑힌 문제 수신/////
									System.out.println(quiz);
									/// 수신받은 문제 출력////

									//////// 문제 풀기 시작/////
									while (true) {
										System.out.print("o/x를 입력하세요 >>");
										Ox = scan.next();
										// ox입력받음//
										// ox를 입력하지 않았을때//
										if (Ox.equalsIgnoreCase("o") || Ox.equalsIgnoreCase("x")) {
											dos.writeUTF(Ox); // ox일때만 전송
											break;
										} else {
											System.out.println("잘못된입력입니다");
											continue; // 오류입력시 문제 풀기 시작점으로 돌아간다
										}
									} /// 문제 풀기 종료/////////////////////

									
									////// 풀었던 문자의 정답을 수신/////
									ansOx = dis.readUTF();
									
									//채점 결과 출력//
									if (ansOx.equals("정답")) {
										answer++;// 정답일때는 정답횟수 올라감
										System.out.println("정답입니다!");
									} else if (ansOx.equals("오답")) {
										System.out.println("틀렸습니다.....");
									}
									count++;
									////// 수신받은 정답 체점 끝////////

								} // 문제3개 출력 for반복문종료
							} //문제풀이 와일 반복문 종료
							
								//////// 퀴즈게임 종료///////////////
							
							
							if(noMoney==false) {//참가금이 충분할때

							if (answer == 3) {
								System.out.println("우승하셨습니다!" + gameMoney * 3 + "원을 상금으로 받습니다!");
								money = money + gameMoney * 2;// 참가비의 2배추가
								answer = 0;// 정답갯수 초기화
								game=true;
								break;
							} else {
								System.out.println("아쉽네요.. 참가금은 돌려드릴수 없습니다");
								money -= gameMoney; // 참가비 만큼 감소
								answer = 0;// 정답갯수 초기화
								game=true;
								break;
							}
							}else {noMoney=false;}//참가금이 부족할때, 참가금을 초기화하고 진행

						} else if (Ox.equalsIgnoreCase("x")) {
							System.out.println("퀴즈 게임을 종료합니다");
							break;
						} else {
							System.out.println("잘못 입력하셨습니다");
							continue;
						}
						// 게임참가 묻기 종료

					} // 여기가 게임 마지막

					break;
				case 2:
					System.out.println("소지금 입니다 : "+money);
					break;
				case 3:
					// 냄비 메뉴
					System.out.println("냄비를 봅니다.");
					ns.nembi();
					if(topoki==true) {dos.writeInt(9999);//게임 종료코드 전송
					System.out.println("수고하셨습니다! 게임을 종료합니다!");
					break 종료;}
					break;
				case 4:
					// 상점 메뉴
					ns.store();
					break;
				case 5:
					// 게임종료
					dos.writeInt(9999);//게임 종료코드 전송
					System.out.println("게임을 종료합니다");
					break 종료;
				default:
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("잘못된 입력입니다.");
				scan.next();
				continue;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			dis.close();
			dos.close();
			is.close();
			os.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}