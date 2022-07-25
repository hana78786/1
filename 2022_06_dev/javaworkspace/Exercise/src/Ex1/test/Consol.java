package Ex1.test;

import java.util.Scanner;

public class Consol {
	
	public static void extracted() {
		System.out.println("<<< 경마게임에 오신 것을 환영합니다. >>>"); // 메뉴출력
		System.out.println("1. 게임시작");
		System.out.println("2. 잔액충전");
		System.out.println("3. 잔액조회");
		System.out.println("4. 게임 종료");
		System.out.println("메뉴를 선택해주세요.");
		System.out.print(">>");
	}
	
	public static int horseChoice(Scanner scan) {
		int horse;
		System.out.println("게임을 시작합니다."); // 게임 메뉴출력
		System.out.println("1. 우승 경력이 많지만 은퇴를 앞둔 말");
		System.out.println("2. 이번달 성적이 제일 좋은 말");
		System.out.println("3. 최근 떠오르는 신예인 말");
		System.out.print("배팅 하고 싶은 말을 선택해주세요. >>");
		horse = scan.nextInt(); // 입력한 말
		return horse;
	}

	public static int moneyPlus(int money, Scanner scan) {
		int moneyPlus = 0;
		while(moneyPlus <= 0) {
		System.out.print("얼마를 충전하시겠습까 ? ");	
		moneyPlus = scan.nextInt();// 충전금액 변수
		if(moneyPlus <= 0) {
			System.out.println("1원 이상 충전가능합니다.");
		}
		else {
		System.out.println(moneyPlus + "원이 충전되었습니다.");
		money = money + moneyPlus; // 충전금액만큼 더한다.
		}
		}
		return money;
	}

}
