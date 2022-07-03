package make.topokki;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GameIn {
	int tock;
	int gochujang;
	int odeng;
	int dangmen;
	int egg;
	int dashida;
	int money = 1000;
	String Ox;
	Scanner scan = new Scanner(System.in);
	String[] quizNum = new String[10];
	boolean[] quizAnswer = new boolean[10];
	int answer = 0;
	Random random = new Random();
	Topoki_Client tc = new Topoki_Client();

	public void quizMenu() {
		System.out.println("==================");
		System.out.println("퀴즈게임!!");
		while (true) {
			try {
				Thread.sleep(300);
				System.out.println("퀴즈는 총 3문제");
				Thread.sleep(300);
				System.out.println("ox를 맞추시면 참가비에 3배를 받습니다!");
				System.out.println("참가 하시겠습니까?");
				Thread.sleep(300);
				System.out.print("ox를 입력하세요 >>");
				Ox = scan.next();
				if (Ox.equals("o") || Ox.equals("O")) {
					System.out.println("퀴즈 게임을 시작합니다!!");
					Thread.sleep(300);
					System.out.println("==================");

					quizStart();

				} else if (Ox.equals("x") || Ox.equals("X")) {
					System.out.println("퀴즈 게임을 종료합니다");
					break;
				} else {
					System.out.println("잘못 입력하셨습니다");
					continue;
				}

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InputMismatchException e) {
				System.out.println("잘못된 입력입니다.");
				scan.next();
				continue;

			}
		}

	}

	public void quizStart() {
		// TODO Auto-generated method stub
		종료: while (true) {
			int[] ranArr = new int[3]; // 번도 3개 저장할 배열
			try {
				System.out.println("참가비를 입력해주세요 :");
				int gameMoney = scan.nextInt();
				if (gameMoney > money) {
					System.out.println("돈이 부족합니다.");
					break;
				}
				quiz_random();
				System.out.println("=======================");

				for (int a = 0; a < 3; a++) {

					for (int i = 0; i < 3; i++) {// 중복 방지 코드
						System.out.println((i + 1) + "번 문제 :");
						ranArr[i] = random.nextInt(10);
						for (int j = 0; j < i; j++) {
							if (ranArr[i] == ranArr[j]) {
								i--;
							}
						}
					}
					
					
					System.out.println(quizNum[ranArr[a]]);
					while (true) {
						System.out.print("o/x를 입력하세요 >>");
						Ox = scan.next();
						if ((quizAnswer[a] == true && Ox.equalsIgnoreCase("o"))
								|| (quizAnswer[a] == false && Ox.equalsIgnoreCase("x"))) {
							answer++;
							System.out.println("정답입니다!");
							break;
						} // 정답일때

						else if ((quizAnswer[a] == true && Ox.equalsIgnoreCase("x"))
								|| (quizAnswer[a] == false && Ox.equalsIgnoreCase("o"))) {
							System.out.println("틀렸습니다.....");
							break;
						} // 오답일때
						else {
							System.out.println("잘못된입력입니다");
							scan.next();
							continue; // 오류입력시 돌아감

						}

					}

				}//여기까지 퀴즈 3문제 내는 반복식
				
				
				
				if (answer == 3) {
					System.out.println("우승하셨습니다!" + gameMoney * 3 + "원을 상금으로 받습니다!");
					money = money + gameMoney * 2;// 참가비의 2배추가
				} else {
					System.out.println("아쉽네요.. 참가금은 돌려드릴수 없습니다");
					money -= gameMoney; // 참가비 만큼 감소
				}
				break 종료; // 퀴즈게임종료
			} catch (InputMismatchException e) {
				System.out.println("잘못된 입력입니다.");
				scan.next();
				continue;

			}
		}

	}

	public void quiz_random() {
		quizNum[0] = "자바의 특징 5가지는 아래와 같다\n 1) 객체 지향 프로그래밍(OOP) \n 2) 자동 메모리 관리(gc)\n 3) 운영체제에 독립적 \n 4) 멀티쓰레드 지원  5)동적 로딩 지원\n";
		quizNum[1] = "캡술화 과정에서 정보 은닉을 위해 변수는 public으로 메서드는 private으로 선언한다";
		quizNum[2] = "인터페이스는 단일 상속만 가능하다";
		quizNum[3] = "부모-자식 클래스는 단일 상속만 가능하다";
		quizNum[4] = "String과 float, int의 크기는 4바이트로 같다";
		quizNum[5] = "a = 1 ; b = 2 ; \n" + "c = ++a + b--; 일때 c의 값은 3이다 ";
		quizNum[6] = "final은 변수명으로 사용할 수 있다";
		quizNum[7] = "1_num은 변수명으로 사용할 수 없다";
		quizNum[8] = "String a =\"2\" ; String b =\"3\"; 일때 \n System.out.println(a+b);의 값은 5이다";

		quizNum[9] = "String a =\"2\" ; String b =\"3\"; 일때 \n System.out.println(a+b);의 값은 23이다";

		boolean quizAnswer[] = { true, false, false, true, true, false, false, true, false, true };// 답 모음
	}

}
