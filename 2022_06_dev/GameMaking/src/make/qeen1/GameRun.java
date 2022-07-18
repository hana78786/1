package make.qeen1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameRun {
	static GamePrint gp = new GamePrint();
	static Scheculer1 sche = new Scheculer1();
	static Scanner scan = new Scanner(System.in);
	static boolean end= false;

	public static void main(String[] args) {

		try {

			System.out.println(">>>>>>>>>>>>>>>퀸 메이커 <<<<<<<<<<<<<<<");
			Thread.sleep(500);
			System.out.println("------------게임을 시작합니다!-------------");

			Thread.sleep(500);
			System.out.println("당신은 공주님의 집사가 되어 공주님을 여왕으로 키우게 됩니다!");
			Thread.sleep(300);
			System.out.println("공주님은 15살, 앞으로 5년동안 훌륭한 여왕으로 키워내는것이 목표입니다.");
			Thread.sleep(300);
			System.out.println("스케쥴은 1년에 3번 분기마다 작성합니다");
			Thread.sleep(300);
			System.out.println("공주님을 여왕으로 만들어보세요!");
			Thread.sleep(300);
			System.out.println("----------------------------------------");
			System.out.println("----------------------------------------");
			System.out.println("----------------------------------------");
			int s = 0;
			while (true) {
				try {
					System.out.println("1. 새 게임");
					System.out.println("2. 게임을 불러온다.");
					s = scan.nextInt();
					if (s == 2) {
						gp.load();
						break;
					} else if (s == 1) {
						gp.prinPrint();
						break;
					} else {
						System.out.println("다시 선택해주세요");
					}
				} catch (InputMismatchException e) { // 잘못입력시 메뉴반복
					System.out.println("잘못된 입력입니다.");
					scan.next();
					continue;
				}
			}

			종료: while (gp.turn < 64) { // 턴은 60턴까지 작동하지만 만의 하나를 위해 넉넉하게 턴을 줘봤다

				if (gp.month == 13) { // 월이 13이 되면 1로 초기화 하고 나이를 한살 먹는다
					gp.month = 1;
					gp.year++;

				}
				if (gp.year == 20) { // 나이가 20살이 되면 종료한다
					break 종료;
				} else {
					if (sche.stress < 0) {
						sche.stress = 0;
					}
					System.out.println("-----------------------------------------");
					System.out.println("현재 나이 " + gp.year + "살 " + gp.month + "월");
					System.out.println("무엇을 할까요?");
					System.out.println("1. 능력치를 확인한다");
					System.out.println("2. 스케줄을 작성한다.");
					System.out.println("3. 상점에 간다.");
					System.out.println("4. 게임을 저장한다");
					System.out.println("5. 게임을 종료한다.");

					System.out.print(">>");
					try {
						int sel = scan.nextInt();
						if (sel == 1) {
							gp.printParameter(); // 현재 능력치를 볼수있다
						} else if (sel == 2) {
							gp.schedule(); // 스케쥴을 작성한다

						} else if (sel == 3) {
							gp.store(); // 상점으로 간다
						} else if (sel == 4) {
							gp.save(); // 저장한다
						} 
						else if (sel == 5) {
							System.out.println("게임을 종료합니다.");
							end = true;
							break 종료; // 저장한다
						}else {
							System.out.println("잘못누르셨습니다"); // 메뉴가 다시 나온다
						}
					} catch (InputMismatchException e) { // 잘못입력시 메뉴반복
						System.out.println("잘못된 입력입니다.");
						scan.next();
						continue;
					}
				}

			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(end== true) {
			System.out.println("다음에 다시 만나요!");
		}else {
		gp.ending();}

	}

}
