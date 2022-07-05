package make.qeen;

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
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class GamePrint {
	Scanner scan = new Scanner(System.in);
	static String name;
	static int birthMon = 100;
	static int birthDay = 100;
	static int month = 1;
	static int year = 15;
	static int turn = 0;
	String[] gameTurn = new String[65];
	Scheculer1 sche = new Scheculer1();
	InputStream is = null;
	OutputStream os = null;
	Writer write = null;
	Reader reader = null;

	
	public void prinPrint() {
		try {
			Thread.sleep(100);
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⢻⣿⣿⣿⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡏⠉⣿⣿⣷⠄⢼⣿⣿⣇⣀⣽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
			Thread.sleep(100);
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠉⠙⠟⠉⠀⠈⠛⠉⠀⠘⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
			Thread.sleep(100);
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢂⣠⣤⣶⣶⣶⣶⣶⣦⣤⣀⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
			Thread.sleep(100);
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
			Thread.sleep(100);
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣯⣿⣿⡿⠉⠻⠿⠙⠿⠟⠙⠿⠟⠻⣿⣿⣿⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
			Thread.sleep(100);
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣾⣿⡟⠀⠀⠒⠛⠃⠀⠀⠐⠛⠒⠀⠀⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
			Thread.sleep(100);
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠛⠛⠃⠀⠀⡼⠶⡄⠀⠀⢠⠷⢦⠀⠀⠘⠛⠛⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
			Thread.sleep(100);
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡀⠀⠀⠀⠀⠀⠁⠀⠉⠀⠀⠈⠀⠈⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
			Thread.sleep(100);
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣿⡄⠀⠀⠀⠀⠀⠈⠀⠀⠀⠀⠀⠀⢠⣿⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
			Thread.sleep(100);
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠉⠉⠁⠀⠀⠀⠀⠀⠘⠤⠤⠃⠀⠀⠀⠀⠀⠀⠉⠙⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿");
			Thread.sleep(100);
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⣿⣿⣿⣿⣿⣿⣿");
			Thread.sleep(100);
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣿⣿⣿⣿⣿⣿⣿⣿");
			Thread.sleep(100);
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⠦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢾⣿⣿⣿⣿⣿⣿⣿⣿⣿");
			Thread.sleep(100);
			System.out.println("⣿⣿⣿⣿⣿⣿⠟⠛⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡀⠀⠀⠀⠀⠉⠛⠿⣿⣿⣿⣿⣿⣿");
			Thread.sleep(100);
			System.out.println("⣿⣿⡿⠋⠁⠀⠀⠀⠀⠀⠀⠀⢀⣴⣾⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣿⣦⡀⠀⠀⠀⠀⠀⠀⠉⠉⠻⣿⣿");
			Thread.sleep(100);
			System.out.println("⣿⣿⣿⣷⡆⢀⡀⠀⠀⢀⣠⣶⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⢰⣿⣿⣿⣿⣆⡀⠀⠀⢀⡀⠐⣶⣿⣿⣿");
			Thread.sleep(100);
			System.out.println("⣿⣿⣿⣿⣿⣿⣷⣤⣴⣿⣿⣿⣿⣿⡿⠟⠀⠀⠀⠀⠀⠀⠀⠀⠚⢿⣿⣿⣿⣿⣿⣶⣦⣾⣿⣿⣿⣿⣿⣿");
			Thread.sleep(100);
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
			Thread.sleep(100);
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠏⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
			Thread.sleep(100);
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿");
			Thread.sleep(100);
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠻⣿⣿⣿⣿⣿⣿⣿⣿");
			Thread.sleep(100);
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⣿⣿⣿⣿⣿⣿⣿");
			Thread.sleep(100);
			System.out.println("⣿⣿⣿⣿⣿⣿⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⣿⣿⣿⣿⣿⣿");
			Thread.sleep(100);
			System.out.println("⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿");
			Thread.sleep(100);
			System.out.println("⣿⣿⣿⣿⣿⣿⣄⢀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠀⣀⡀⣀⣿⣿⣿⣿⣿⣿");
			Thread.sleep(100);
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣿⣶⣶⣷⣶⣷⣶⣿⣶⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
			Thread.sleep(100);
			System.out.println("⣿⣿⣿⣿⣿⣿      ~  Q e e n  M a k e r ~    ⣿⣿⣿⣿⣿");
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		int YesNo = 0;// 예 아니요 확인하는 변수

		while (YesNo != 1) { // 이름 입력받기
			YesNo = 0;

			System.out.println("공주님의 이름은 무엇인가요?");
			System.out.print(">>");
			name = scan.next();

			try {
				System.out.println(name + " 공주님이 맞나요?"); // 이름확인
				System.out.println("예 1, 아니오  2");
				System.out.print(">>");
				YesNo = scan.nextInt();
				if (YesNo != 1 && YesNo != 2) {
					System.out.println("잘못 입력하셨습니다");
				}
			} catch (InputMismatchException e) {
				System.out.println("잘못된 입력입니다.");
				scan.next();
				continue;
			}
		}

		do {
			YesNo = 0;

			while (birthMon > 13 || birthMon < 0) { // 월을 입력받는다
				try {
					System.out.println("공주님의 생일은 몇 월 인가요? (숫자만입력하세요)");
					System.out.print(">>");
					birthMon = scan.nextInt();
					if (birthMon > 13 || birthMon < 0) {
						System.out.println("잘못입력하셨습니다.");
					}
				} catch (InputMismatchException e) {
					System.out.println("잘못된 입력입니다.");
					scan.next();
					continue;
				}
			}

			while (birthDay > 32 || birthDay < 0) {// 일을 입력받는다
				try {
					System.out.println("공주님의 생일은 몇 일 인가요? (숫자만입력하세요)");
					System.out.print(">>");
					birthDay = scan.nextInt();

					if (birthDay > 32 || birthDay < 0) {
						System.out.println("잘못입력하셨습니다.");
					}
				} catch (InputMismatchException e) {
					System.out.println("잘못된 입력입니다.");
					scan.next();
					continue;
				}
			}

			while (YesNo != 1 && YesNo != 2) { // 생일이 맞는지 확인한다
				try {
					System.out.println("공주님의 생일은 " + birthMon + "월 " + birthDay + "일 이 맞나요?");
					System.out.println("예 1, 아니오  2");
					System.out.print(">>");
					YesNo = scan.nextInt();

					if (YesNo != 1 && YesNo != 2) {
						System.out.println("잘못 입력하셨습니다");
					} else if (YesNo == 2) {
						System.out.println("생일을 다시입력합니다");
						birthMon = 100; // 생일을 다시 입력받기에 초기화
						birthDay = 100; // 생일을 다시 입력받기에 초기화

					}
				} catch (InputMismatchException e) {
					System.out.println("잘못된 입력입니다.");
					scan.next();
					continue;
				}
			}

		} while ((birthMon > 13 && birthMon < 0) || (birthDay > 32 && birthDay < 0) || YesNo == 2);
		// 반복문의 조건은 월을 13이상 0이하로 적지 말것, 일을 32이상 0이하로 적지 말것, 생일이 맞는지 확인시 아니오 선택했을때

		System.out.println(name + " 공주님은 " + birthMon + "월 " + birthDay + "일이 생일이시군요");

	}

	public void schedule() {// 스케쥴을 실행하는 메소드

		System.out.println(name + " 공주님의 스케줄을 정합니다. 스케줄은 1달에 1번씩 4번 고를수 있습니다.");
		for (int i = 0; i < 4; i++) { // 스케쥴은 한번에 4개씩 입력할수 있습니다. 일년에 3번 스케쥴을 선택합니다.

			System.out.println(year + "살 " + month + "월의 스케쥴");
			System.out.println("----------------------------------------");
			System.out.println("1. 아르바이트를 한다");
			System.out.println("2. 공부를 한다");
			System.out.println("3. 휴식한다.");
			System.out.println("4. 20살까지 아무것도 하지 않는다.");
			System.out.println("----------------------------------------");
			System.out.print(">>");
			String sel = scan.next();
			switch (sel) {
			case "1":
				scheWork();// 아르바이트 선택
				month++;
				break;
			case "2":
				scheStudy();// 공부선택
				month++;
				break;
			case "3":
				System.out.println("휴식합니다");
				gameTurn[turn] = "휴식";
				System.out.println(gameTurn[turn]);
				month++;
				turn++;
				break;
			case "4":// 강제 엔딩을 볼수있습니다.
				i = 4;
				turn = 64;
				break;
			default:
				System.out.println("잘못된 입력입니다");
				break;

			}
		}
		if (turn < 64) {
			runSchedule();// 턴이 충분하지 않으면 스케쥴을 실행합니다.
		} else {
		}

	}

	private void runSchedule() {
		for (int i = 4; i > 0; i--) {// 한번당 4번 실행되는 스케쥴입니다
			System.out.println("스케쥴을 실행합니다.");
			System.out.println(name + " 공주님의 " + (month - i) + "월 스케쥴은 " + gameTurn[turn - i] + " 입니다");
			System.out.println(gameTurn[turn - i] + "을/를 실행합니다");

			if ((month - i) == birthMon) {// 생일 월이 되면 선물을 받습니다
				try {
					Thread.sleep(200);
					System.out.println("-------------------------");
					System.out.println(name + " 공주님 생일 축하드려요!");
					Thread.sleep(200);
					System.out.println("왕궁에서 생일 선물로 용돈이 왔어요!");
					Thread.sleep(200);
					System.out.println("[100g를 받았습니다]");
					Thread.sleep(200);
					sche.money += 100;
					System.out.println("-------------------------");
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (gameTurn[turn - i].equals("농부알바")) {
				sche.farm();
			} else if (gameTurn[turn - i].equals("식당알바")) {
				sche.cafe();

			} else if (gameTurn[turn - i].equals("보모알바")) {
				sche.child();

			} else if (gameTurn[turn - i].equals("음악교실")) {
				sche.musicschool();

			} else if (gameTurn[turn - i].equals("무술교실")) {
				sche.martial();

			} else if (gameTurn[turn - i].equals("그림교실")) {
				sche.artschool();
			} else if (gameTurn[turn - i].equals("휴식")) {
				sche.rest();
			}

		}

	}

	public void ending() { // 엔딩을 보는 메소드
		Ending end = new Ending(); // 엔딩을 모아놓은 클래스

		try {
			System.out.println(name + " 공주님은 드디어 20살이 되었습니다.");
			Thread.sleep(100);
			System.out.println(name + " 공주님에겐 어떤 미래가 기다리고 있을까요?");
			Thread.sleep(1000);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (sche.art < 10 && sche.study < 10 && sche.music < 10 && sche.cook < 10 && sche.strong < 10
				&& sche.manner < 10) {
			end.neet();// 모든 능력치가 10 미만이면 백수엔딩입니다.
		} else if (sche.art < 30 || sche.study < 30 || sche.music < 30 || sche.cook < 30 || sche.strong < 30
				|| sche.manner < 30) {// 모든 능력치가 30미만이면 아르바이트엔딩입니다
			if (sche.farm > sche.cafe && sche.farm > sche.child) {
				// 농부알바를 제일 많이 했다면 농부엔딩
				end.endFarm();

			} else if (sche.cafe > sche.child) {
				// 식당알바를 제일 많이 했다면 식당직원 엔딩
				end.endCafe();
			} else if (sche.child > 0) {
				// 보모 알바를 제일 많이 했다면 보모엔딩
				end.endChild();
			} else {
				// 알바를 하지 않았다면 프리터 엔딩
				end.freetor();
			}

		} else if (sche.art < 60 || sche.study < 60 || sche.music < 60 || sche.cook < 60 || sche.strong < 60
				|| sche.manner < 60) {// 모든 능력치가 30이상 60미만일때 직업엔딩을 봅니다
			if (sche.martial > sche.artSchool && sche.martial > sche.musicSchool && sche.power > 40) {
				// 힘이 40이상이고 무술수업을 가장 많으면 장군엔딩
				end.genal();
			} else if (sche.artSchool > sche.musicSchool && sche.art > 40) {
				// 그럼수업이 가장 많이 받고 미술이 40 이상이면 화가 엔딩
				end.artist();
			} else if (sche.musicSchool > 0 && sche.music > 40) {
				// 음악수업이 가장 많으면서 음악이 40이상이면 음악가 엔딩
				end.musician();
			} else {
				// 수업을 받지 않았거나 40넘는 페라메터가 없으면 공무원엔딩
				end.servent();
			}
		} else if (sche.art >= 60 && sche.study >= 60 && sche.music >= 60 && sche.cook >= 60 && sche.strong >= 60
				&& sche.manner >= 60) {
			// 모든 능력치가 60이 넘으면 여왕엔딩
			end.Qeen();
		} else {
			// 만약 모든것에 해당사항이 없다면 공무원엔딩 아마 이 부분은 없겠지만 만의 하나를 위해 넣었습니다
			end.servent();
		}

	}

	public void scheWork() {// 아르바이트 스케쥴 메소드
		String sel = "";
		종료: while (!sel.equals("1") || !sel.equals("2") || !sel.equals("3")) {
			System.out.println("아르바이트를 합니다");
			System.out.println("어떤 아르바이트를 할까요?");

			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("1. 농부알바 / 급료 20g");
			System.out.println("2. 식당알바 / 급료 15g");
			System.out.println("3. 보모알바 / 급료 15g");
			System.out.println(">>");
			sel = scan.next();
			switch (sel) {
			case "1":
				System.out.println("농부 알바를 선택하셨습니다");
				gameTurn[turn] = "농부알바";

				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				turn++;
				break 종료;
			case "2":
				System.out.println("식당 알바를 선택하셨습니다");
				gameTurn[turn] = "식당알바";

				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				turn++;
				break 종료;
			case "3":
				System.out.println("보모 알바를 선택하셨습니다");
				gameTurn[turn] = "보모알바";

				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				turn++;
				break 종료;
			default:
				System.out.println("잘못된 입력입니다");
				break;
			}
		}
	}

	public void scheStudy() {// 공부 스케쥴 메소드
		String sel = "";
		종료: while (!sel.equals("1") || !sel.equals("2") || !sel.equals("3")) {
			System.out.println("공부를 합니다");
			System.out.println("어떤 공부를 할까요?");
			System.out.println("1. 음악교실 / 교육비 : 50g");
			System.out.println("2. 무술교실 / 교육비 : 50g");
			System.out.println("3. 그림교실 / 교육비 : 50g");
			System.out.println(">>");
			sel = scan.next();
			switch (sel) {
			case "1":
				System.out.println("음악교실을 선택하셨습니다");
				gameTurn[turn] = "음악교실";

				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				turn++;
				break 종료;
			case "2":
				System.out.println("무술교실을 선택하셨습니다");
				gameTurn[turn] = "무술교실";

				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				turn++;
				break 종료;
			case "3":
				System.out.println("그림교실을 선택하셨습니다");
				gameTurn[turn] = "그림교실";

				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				turn++;
				break 종료;
			default:
				System.out.println("잘못된 입력입니다");
				break;
			}
		}

	}

	public void printParameter() {// 능력치 표현 메소드 원래 gettersetter로 하고 싶었는데 안됐어요...
		System.out.println("----------- 현재 상태 ----------");
		System.out.println("힘 : " + sche.power + "  " + "근성 : " + sche.strong);
		System.out.println("학력 : " + sche.study + "  " + "요리 : " + sche.cook);
		System.out.println("음악 : " + sche.music + "  " + "미술 : " + sche.art);
		System.out.println("예절 : " + sche.manner);
		System.out.println("재산 : " + sche.money + "  " + "스트레스 : " + sche.stress);
		System.out.println("----------------------------");
	}

	public void store() {// 상점 메소드
		// TODO Auto-generated method stub
		System.out.println("⡟⣭⣭⣭⣭⣭⣭⣭⣭⣭⣭⣭⡭⠍⠍⠭⠩⠩⠭⠉⠭⠉⠩⠭⠍⠩⠩⢩⣭⣭⣭⣭⣭⣭⣭⣭⣭⣭⣭⢻");
		System.out.println("⡇⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢸");
		System.out.println("⡇⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠸⢯⡃⢹⡏⢱⡟⢻⣼⣯⡿⢸⣯⠅⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢸");
		System.out.println("⡇⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠘⠚⠃⠈⠃⠈⠛⠛⠈⠃⠛⠘⠓⠂⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢸");
		System.out.println("⣇⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣇⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⣸");
		System.out.println("⣿⣷⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⣾⣿");
		System.out.println("⣿⣿⢸⣿⠛⠛⠙⠉⠋⠙⠛⣻⠉⠛⠛⠛⠙⠋⠙⠛⠛⠙⠉⠋⠛⠛⠛⠉⣿⠙⠛⠋⠛⠛⠙⠛⣿⡇⣿⣿");
		System.out.println("⣿⣿⢸⣿⠀⠀⠀⠀⠀⠀⠀⢻⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⣿⡇⣿⣿");
		System.out.println("⣿⣿⢸⣿⠀⠀⠀⠀⠀⠀⠀⣹⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⣿⡇⣿⣿");
		System.out.println("⣿⣿⢸⣿⠀⠀⠀⠀⠀⠀⠀⣾⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⣿⡇⣿⣿");
		System.out.println("⣿⣿⢸⣿⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⠀⠀⠾⠀⠀⠺⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⣿⡇⣿⣿");
		System.out.println("⣿⣿⢸⣿⠀⠀⠀⠀⠀⠀⠀⢿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⣿⡇⣿⣿");
		System.out.println("⣿⣿⢸⣿⠀⠀⠀⠀⠀⠀⠀⣾⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⣿⡇⣿⣿");
		System.out.println("⣿⣿⢸⣿⣀⣀⣀⣀⣀⣀⣀⣽⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣯⣀⣀⣀⣀⣀⣀⣀⣿⡇⣿⣿");
		System.out.println("⣿⣿⣌⣛⣛⣛⣛⣛⣛⣛⣛⣛⣛⣛⣛⣛⣛⣛⣛⣛⣛⣛⣛⣛⣛⣛⣛⣛⣛⣛⣛⣛⣛⣛⣛⣛⣛⣣⣿⣿");
		System.out.println();
		System.out.println();
		System.out.println("상점주인 : 여기는 상점입니다.");
		System.out.println("상점주인 : 필요한걸 살수 있죠");
		System.out.println("상점주인 : 복권도 살수 있습니다.");
		System.out.println("상점주인 : 뭘 사실래요?");
		종료: while (true) {
			System.out.println("-----------------------");
			System.out.println("1. 물건을 산다");
			System.out.println("2. 복권을 산다");
			System.out.println("3. 상점을 나간다");
			System.out.println("-----------------------");
			System.out.print(">>");
			int sel = scan.nextInt();
			switch (sel) {
			case 1:// 물건 메뉴
				sale();
				break;
			case 2:// 복권메뉴
				rotto();
				break;
			case 3:
				System.out.println("상점주인 : 안녕히가세요");
				System.out.println("-----------------------");
				break 종료;
			default:
				System.out.println("다시 입력하세요");
				break;
			}

		}
	}

	public void rotto() {// 복권메소드 복권을 사서 물건을 안사면 상위 엔딩은 안나옵니다.
		int ruckyNum = 0;
		// TODO Auto-generated method stub
		종료: while (true) {
			System.out.println("-----------------------");
			System.out.println("즉석 복권을 구입하실수 있습니다.");
			System.out.println("당첨되면 구입한 가격의 복권의 3배를 받습니다.");
			System.out.println("당첨 숫자 2개를 맞추면 당첨입니다.");
			System.out.println("얼마를 구입하시겠습니까?");
			try {
				System.out.print(">>");
				int Money = scan.nextInt();// 값을 입력받아 복권을 삽니다
				if (Money > sche.money) {
					System.out.println("돈이 부족합니다");
					break 종료; // 소지금보다 많이사면 강제 종료
				} else if (Money < 1) {// 금액을 1미만으로 입력하면 강제종료
					System.out.println("금액을 잘못입력하셨습니다");
					break;
				}

				System.out.println("복권 번호를 입력하세요 7 이하의 수를 3번 입력합니다.");// 밸런스를 위해 애매한 1~7 숫자를 썼습니다.
				int rootoNum[] = new int[3];
				for (int i = 0; i < 3; i++) {// 3개를 입력받습니다, 7보다 큰 수를 입력하면 강제 종료
					System.out.print(">>");
					rootoNum[i] = scan.nextInt();
					if (rootoNum[i] > 7 || rootoNum[i] < 1) {
						System.out.println("잘못 입력하셨습니다");
						break 종료;
					}
				}

				Random random = new Random();
				int ranNum[] = new int[3];
				for (int i = 0; i < 3; i++) {// 중복 랜덤 숫자 방지
					ranNum[i] = random.nextInt(7) + 1;
					for (int j = 0; j < i; j++) {
						if (ranNum[i] == ranNum[j]) {
							i--;
						}
					}
				}

				System.out.println("당첨번호 : " + ranNum[0] + ", " + ranNum[1] + ", " + ranNum[2]);
				System.out.println("내가 고른 번호 : " + rootoNum[0] + ", " + rootoNum[1] + ", " + rootoNum[2]);

				for (int i = 0; i < 3; i++) { // 점수를 계산합니다.
					for (int j = 0; j < 3; j++) {
						if (ranNum[i] == rootoNum[j]) {
							ruckyNum++;
						}
					}
				}

				System.out.println(ruckyNum + "개가 맞았습니다");
				if (ruckyNum >= 2) {
					System.out.println("당첨되셨습니다!");
					System.out.println(Money * 3 + "g을 얻으셨습니다");
					sche.money += Money * 2; // 3배의 당첨금
				} else {
					System.out.println("꽝...");
					sche.money -= Money; //
					System.out.println(Money + "g을 잃으셨습니다");// 판돈을 잃습니다.
				}
				break 종료;

			} catch (InputMismatchException e) {
				System.out.println("잘못된 입력입니다.");
				scan.next();
				continue;
			}

		}
	}

	public void sale() {// 물건구입 메소드 물건을 안사면 상위 엔딩은 못보니다
		// TODO Auto-generated method stub
		종료: while (true) {
			try {
				Thread.sleep(200);
				System.out.println("------물건을 구입합니다------");
				System.out.println("1. 악보 : 음악 10 상승/ 30g");
				System.out.println("2. 인형 : 스트레스 30하락/ 30g");
				System.out.println("3. 목검 : 힘 10 상승, 근성 5 상승/ 30g");
				System.out.println("4. 책  : 학력 10 상승, 예절 10 상승/ 30g");
				System.out.println("5. 냄비 : 요리 10 상승/ 30g");
				System.out.println("6.  붓 : 그림 10 상승/ 30g");
				System.out.println("7. 구입종료");
				System.out.print(">>");
				int sel = scan.nextInt();
				if (sche.money < 30) {
					System.out.println("돈이 부족합니다.");
					break 종료;
				}
				switch (sel) {
				case 1:
					System.out.println("악보를 구입하셨습니다.");
					Thread.sleep(200);
					sche.music += 10;
					sche.money -= 30;
					System.out.println("음악이 10 상승합니다, 재산이 30g 하락합니다");
					Thread.sleep(200);
					System.out.println("-----------------------------");
					break;
				case 2:
					System.out.println("인형을 구입하셨습니다.");
					Thread.sleep(200);
					sche.stress -= 30;
					sche.money -= 30;
					System.out.println("스트레스가 30 하락합니다, 재산이 30g 하락합니다");
					Thread.sleep(200);
					System.out.println("-----------------------------");
					break;
				case 3:
					System.out.println("목검을 구입하셨습니다.");
					Thread.sleep(200);
					sche.power += 10;
					sche.strong += 5;
					sche.money -= 30;
					System.out.println("힘이 10 상승 합니다 근성이 5 상승합니다, 재산이 30g 하락합니다");
					Thread.sleep(200);
					System.out.println("-----------------------------");
					break;
				case 4:
					System.out.println("책을 구입하셨습니다.");
					Thread.sleep(200);
					sche.study += 10;
					sche.manner += 10;
					sche.money -= 30;
					System.out.println("학력이 10 상승합니다 예절이 10 상승합니다, 재산이 30g 하락합니다");
					Thread.sleep(200);
					System.out.println("-----------------------------");
					break;
				case 5:
					System.out.println("냄비를 구입하셨습니다.");
					Thread.sleep(200);
					sche.cook += 10;
					sche.money -= 30;
					System.out.println("요리가 10 상승합니다, 재산이 30g 하락합니다");
					Thread.sleep(200);
					System.out.println("-----------------------------");
					break;
				case 6:
					System.out.println("붓을 구입하셨습니다.");
					Thread.sleep(200);
					sche.art += 10;
					sche.money -= 30;
					System.out.println("그림이 10 상승합니다, 재산이 30g 하락합니다");
					Thread.sleep(200);
					System.out.println("-----------------------------");

					break;
				case 7:
					System.out.println("구입을 종료합니다");
					System.out.println("-----------------------------");
					Thread.sleep(200);
					break 종료;
				default:
					System.out.println("다시 입력하세요");
					Thread.sleep(200);
					break;

				}
			} catch (InputMismatchException e) {
				System.out.println("잘못된 입력입니다.");
				scan.next();
				continue;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void save() {
		System.out.println("게임을 저장합니다.");

		try {
			write = new FileWriter("save.txt");
			write.write(name + "/");
			write.write(birthMon + "/");
			write.write(birthDay + "/");
			write.write(month + "/" + year + "/" + turn + "/");
			write.write(sche.art + "/" + sche.artSchool + "/" + sche.cafe + "/" + sche.child + "/" + sche.cook + "/"
					+ sche.farm + "/" + sche.manner + "/" + sche.martial + "/" + sche.money + "/" + sche.music + "/"
					+ sche.musicSchool + "/" + sche.power + "/" + sche.stress + "/" + sche.strong + "/" + sche.study);
			write.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				write.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void load() {
		// TODO Auto-generated method stub

		String readStr = "";
		BufferedReader bfr = null;

		try {
			reader = new FileReader("save.txt");
			bfr = new BufferedReader(reader);
			readStr = bfr.readLine();
			StringTokenizer st = new StringTokenizer(readStr, "/");
			name = st.nextToken();
			System.out.println(name);
			birthMon = Integer.parseInt(st.nextToken());
			birthDay = Integer.parseInt(st.nextToken());
			month = Integer.parseInt(st.nextToken());
			year = Integer.parseInt(st.nextToken());
			turn = Integer.parseInt(st.nextToken());
			sche.art = Integer.parseInt(st.nextToken());
			sche.artSchool = Integer.parseInt(st.nextToken());
			sche.cafe = Integer.parseInt(st.nextToken());
			sche.child = Integer.parseInt(st.nextToken());
			sche.cook = Integer.parseInt(st.nextToken());
			sche.farm = Integer.parseInt(st.nextToken());
			sche.manner = Integer.parseInt(st.nextToken());
			sche.martial = Integer.parseInt(st.nextToken());
			sche.money = Integer.parseInt(st.nextToken());
			sche.music = Integer.parseInt(st.nextToken());
			sche.musicSchool = Integer.parseInt(st.nextToken());
			sche.power = Integer.parseInt(st.nextToken());
			sche.stress = Integer.parseInt(st.nextToken());
			sche.strong = Integer.parseInt(st.nextToken());
			sche.study = Integer.parseInt(st.nextToken());

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
			}
		}

	}

}
