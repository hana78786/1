package Ex1.test;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Rub {

		public static void main(String[] args) {
			int horse = 0;
			int money = 0;
			int battingMoney = 0;
			int moneyPlus = 0;
			int sel = 0;
			Consol consol = new Consol();

			Scanner scan = new Scanner(System.in);
			종료: while (true) {
				try {
					consol.extracted();
					sel = scan.nextInt(); // 메뉴입력받음
				} catch (InputMismatchException e) {// 정수 외의 다른값이 나왔을때 오류메세지를 출력하고 while뮨으로 돌아간다.
					System.out.println("잘못된 입력입니다.");
					scan.next();
					continue;
				}
				switch (sel) {
				case 1:

					do {
						try {
							horse = consol.horseChoice(scan);
							if (horse <= 0 || horse > 3) { // 1~3을 입력하지 않았을때
								System.out.println("잘못입력하셨습니다.");
								// 반복문을 종료하고 처음으로 돌아간다

							}
						} catch (InputMismatchException ex) {// 정수 외의 다른값이 나왔을때 오류메세지를 출력하고 while뮨으로 돌아간다.
							System.out.println("잘못된 입력입니다.");
							scan.next();
							continue;
						}

					} while (horse <= 0 || horse > 3);

					while (true) {
						try {
							System.out.print("얼마를 배팅하시겠습니까?");
							battingMoney = scan.nextInt(); // 배팅할 값입력
							if (money < battingMoney) {// 현재 money보다 배팅값이 높으면
								System.out.println("잔액이 부족합니다.");
								break; // 반복문 종료
							} else if (battingMoney <= 0) {
								System.out.println("1원이상 배팅해주세요");
								break;
							}

							Random random = new Random();
							int victory = random.nextInt(3) + 1; // 난수는 1~3까지의 값이 무작위로 출력된다.
							System.out.println(victory + "말이 우승하였습니다.");
							if (horse == victory) {// 난수값과 같을때
								System.out.println("배팅에 성공하였습니다...!");
								System.out.println("배팅한 금액의 2배인 " + battingMoney * 2 + "원을 획득하였습니다");
								money = money + battingMoney; // 배팅값을 빼지 않았음으로 배팅값만큼만 더해준다.
							} else {
								System.out.println("배팅에 실패하였습니다...^^");
								System.out.println("배팅한 금액인 " + battingMoney + "원을 모두 잃으셨습니다");
								money = money - battingMoney; // 배팅값을 money에서 뺸다.
							}
						} catch (InputMismatchException e) {// 정수 외의 다른값이 나왔을때 오류메세지를 출력하고 while뮨으로 돌아간다.
							System.out.println("잘못된 입력입니다.");
							scan.next();
							continue;
						}
						break;
					}
					break;

				case 2:
					while (true) {
						try {
							money = consol.moneyPlus(money, scan);
							break;
						} catch (InputMismatchException e) {// 정수 외의 다른값이 나왔을때 오류메세지를 출력하고 while뮨으로 돌아간다.
							System.out.println("잘못된 입력입니다.");
							scan.next();
							continue;
						}
					}
					break;
				case 3:
					System.out.println("현재 잔액은 : " + money + "원 입니다.");// 현재 money를 출력한다.
					break;
				case 4:
					System.out.println("종료합니다.");
					break 종료;
				default:// 정수값이 1~4가 아닐때 나오는 오류메세지
					System.out.println("잘못 입력하셨습니다.");
					break;
				}

			}

		}

		

		

	}


