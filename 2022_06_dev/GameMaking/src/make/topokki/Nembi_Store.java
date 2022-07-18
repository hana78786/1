package make.topokki;

import java.util.Scanner;

public class Nembi_Store {
	public int tock;
	public int gochujang;
	public int odeng;
	public int dangmen;
	public int egg;
	public int dashida;
	Topoki_Client tc = new Topoki_Client();

	public void nembi() {
		try {
			Thread.sleep(300);
			System.out.println("===========================");
			Thread.sleep(300);
			System.out.println("냄비를 확인합니다");
			Thread.sleep(300);

			System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢡⣾⣿⣿⣷⡆⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
			Thread.sleep(300);
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⠟⢛⣉⠭⠥⠼⠛⣿⣿⠛⠓⠬⠭⣍⣛⠻⢿⣿⣿⣿⣿⣿⣿");
			Thread.sleep(300);
			System.out.println("⣿⣿⣿⣿⡿⢋⡴⠊⠁⠀⠀⠀⠀⠾⣿⣿⡿⠀⠀⠀⠀⠈⠙⠢⡙⢿⣿⣿⣿⣿");
			Thread.sleep(300);
			System.out.println("⣿⣿⣿⣿⢡⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⡆⢻⣿⣿⣿");
			Thread.sleep(300);
			System.out.println("⣿⣿⣿⣿⢸⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⡾⡟⢸⣿⣿⣿");
			Thread.sleep(300);
			System.out.println("⣿⣿⣿⣿⣆⠫⣛⠶⣤⣄⡀⠀⠀⠀⠀⠀⣀⣀⣀⣤⣴⠶⠛⢁⡴⣡⣿⣿⣿⣿");
			Thread.sleep(300);
			System.out.println("⣿⣿⣿⣿⣿⣷⣬⣑⠲⠭⢿⣛⣛⣛⣛⣛⣛⣉⣉⡡⠤⠖⣊⣡⣶⣿⣿⣿⣿⣿");
			Thread.sleep(300);
			System.out.println("⣿⣿⣿⣿⣿⣿⣿⠟⢛⣉⠤⠤⠔⠒⠒⠒⠒⠢⠤⠤⣌⣙⠻⢿⣿⣿⣿⣿⣿⣿");
			Thread.sleep(300);
			System.out.println("⣿⣿⣿⣿⡿⢋⠴⠊⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠢⡙⢿⣿⣿⣿⣿");
			Thread.sleep(300);
			System.out.println("⣿⣿⣿⡿⢁⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⡄⠻⢿⣿⣿");
			Thread.sleep(300);
			System.out.println("⣿⡿⢡⣶⣿⢰⣆⠀⠀⠀⠀⣀⣀⣀⣀⣀⣀⣀⡀⠀⠀⠀⢀⣀⠀⣿⣿⣆⢻⣿");
			Thread.sleep(300);
			System.out.println("⣿⡇⢿⣿⣿⣆⠻⣦⣴⡞⠛⠋⠉⠉⠉⠉⠉⠙⠛⣛⣿⣶⠟⠋⣠⣿⣿⣿⢸⣿");
			Thread.sleep(300);
			System.out.println("⣿⣷⣌⠛⢿⡛⠃⠀⠉⠛⠿⠶⠶⠶⠶⠶⠿⠿⠛⠋⠉⠀⠀⠘⠛⡿⠟⣡⣾⣿");
			Thread.sleep(300);
			System.out.println("⣿⣿⣿⣿⠨⡁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⣿⣿⣿⣿");
			Thread.sleep(300);
			System.out.println("⣿⣿⣿⣿⡆⢇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⢃⣿⣿⣿⣿");
			Thread.sleep(300);
			System.out.println("⣿⣿⣿⣿⣿⣌⠣⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⠔⣡⣾⣿⣿⣿⣿");
			Thread.sleep(300);
			System.out.println("⣿⣿⣿⣿⣿⣿⣷⣦⣍⣓⠒⠲⠤⠤⠤⠤⠤⠤⠔⠒⣒⣩⣴⣾⣿⣿⣿⣿⣿⣿");
			Thread.sleep(300);

			System.out.println("냄비에는 ....");
			System.out.println("떡이 " + tock + "개");
			System.out.println("어묵이 " + odeng + "개");
			System.out.println("고추장이 " + gochujang + "개");
			System.out.println("당면이 " + dangmen + "개");
			System.out.println("삶은 달걀이 " + egg + "개");
			System.out.println("고양이맛 다싯다가 " + dashida + "개");
			System.out.println("있습니다");

			String ox = "";
			while (!ox.equalsIgnoreCase("o") || !ox.equalsIgnoreCase("x")) {
				System.out.println("떡볶이를 만드시겠습니까?");
				Scanner scan = new Scanner(System.in);
				System.out.print("ox로 대답하세요 >>");
				ox = scan.next();
				if (ox.equalsIgnoreCase("o")) {
					if (tock < 1 || gochujang < 1 || odeng < 1 || dangmen < 1 || egg < 1 || dashida < 1) {
						System.out.println("재료가 부족합니다");
						break;
					} else {
						System.out.println("떡복이를 만듭니다!");
						Thread.sleep(300);
						System.out.println("⣿⣿⣿⣿⣿⣿⣿⠿⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠛⠛⠉⠉⠙⢿⣿⣿⣿⣿⣿");
						Thread.sleep(300);
						System.out.println("⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⢿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿");
						Thread.sleep(300);
						System.out.println("⣿⣿⣿⣿⡏⠀⠀⠀⠀⠀⠀⣿⣿⠛⠉⠙⠿⣿⣇⠀⠀⠀⠀⠀⢀⣿⣿⣿⣿⣿");
						Thread.sleep(300);
						System.out.println("⣿⣿⣿⣿⣷⣤⣤⡀⢀⠴⠞⢟⡃⠀⠀⠀⠀⠈⡛⠗⢶⢤⣤⣶⣿⣿⣿⣿⣿⣿");
						Thread.sleep(300);
						System.out.println("⣿⣿⣿⣿⣿⣿⢛⣡⣦⣾⣿⣿⠇⠀⠀⠀⠀⡀⣿⠀⢀⣦⠈⠛⠿⢿⣿⣿⣿⣿");
						Thread.sleep(300);
						System.out.println("⣿⣿⣿⠿⠋⣦⣾⣿⣿⡟⠁⢿⣠⣴⣢⢤⣺⣧⣄⡠⠊⠀⡷⠋⣱⣷⠈⣿⣿⣿");
						Thread.sleep(300);
						System.out.println("⡿⠿⠏⣷⡀⢼⣿⠿⠿⠶⢽⣿⣿⣿⣿⣿⣿⣿⡿⢁⠤⢼⠁⠰⠋⣸⡀⠘⠛⢿");
						Thread.sleep(300);
						System.out.println("⠁⠀⠀⣹⣷⢺⡇⠀⠀⠀⢠⠿⠿⠿⣿⣿⣿⢫⡳⢠⢿⡎⢀⣶⡔⠟⡸⠀⠀⠀");
						Thread.sleep(300);
						System.out.println("⣄⠀⠀⠇⠌⡟⠓⠤⢤⠤⠃⠀⠀⠀⡿⢿⠃⣺⡇⡾⣽⠁⠼⣿⢇⡴⠁⢀⢀⣸");
						Thread.sleep(300);
						System.out.println("⣿⣿⣧⠈⠲⢧⣄⣀⣼⡀⠀⠀⢀⡰⠁⡌⣘⡾⢰⣽⢣⢁⣙⡥⠊⠀⢠⣿⣿⣿");
						Thread.sleep(300);
						System.out.println("⣿⣿⣿⣧⡀⠀⠀⠉⠉⠙⠛⠛⠛⠛⠛⠓⠛⠓⠒⠒⠙⠉⠁⠀⠀⣠⣿⣿⣿⣿");
						Thread.sleep(300);
						System.out.println("⣿⣿⣿⣿⣿⣦⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣾⣿⣿⣿⣿⣿");
						Thread.sleep(300);
						System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣶⣦⣤⣄⣀⣀⣀⣀⣀⣀⣀⣤⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿");

						System.out.println("맛있다!!! ");
						System.out.println("떡볶이 만들기 성공!");
						tc.topoki = true;
						break;

					}
				}

				else if (ox.equalsIgnoreCase("x")) {
					break;

				} else {
					System.out.println("잘못입력하셨습니다.");
				}
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void store() {
		Scanner scan = new Scanner(System.in);
		System.out.println("=======================");
		try {
			Thread.sleep(300);
			System.out.println("상점에 도착했습니다.");
			Thread.sleep(300);

			System.out.println("⣯⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⣹");
			Thread.sleep(300);
			System.out.println("⣿⣶⣶⣶⣶⣶⣶⣶⣶⡆⢤⠄⢤⠤⡤⢤⢠⢤⢠⠀⢰⣶⣶⣶⣶⣶⣶⣶⣶⣿");
			Thread.sleep(300);
			System.out.println("⣿⣻⣿⣻⣛⣻⡿⠛⡻⠇⠒⠃⠘⠀⠓⠚⠘⠑⠘⠀⢸⡿⣿⡿⡿⡟⣿⣛⣿⣿");
			Thread.sleep(300);
			System.out.println("⣏⡻⠛⣯⣯⣯⣼⣴⣤⣥⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣼⣿⣿⣿⣷⣯⣯⠛⢅⣻");
			Thread.sleep(300);
			System.out.println("⣿⡇⠀⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠀⢸⣿");
			Thread.sleep(300);
			System.out.println("⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿");
			Thread.sleep(300);
			System.out.println("⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿");
			Thread.sleep(300);
			System.out.println("⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠰⠀⠀⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿");
			Thread.sleep(300);
			System.out.println("⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿");
			Thread.sleep(300);
			System.out.println("⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿");
			Thread.sleep(300);
			System.out.println("⣿⣧⣠⣤⣤⣤⣤⣤⣠⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣀⣼⣿");
			Thread.sleep(300);

			종료: while (true) {
				System.out.println("=====================");
				System.out.println("무엇을 구입하시겠습니까?");
				System.out.println("1.떡볶이 떡 : 3000원");
				System.out.println("2.고추창 : 5000원");
				System.out.println("3.어묵 : 5000원");
				System.out.println("4.넓적당면 : 8000원");
				System.out.println("5.삶은 달걀 : 1000원");
				System.out.println("6.고양이맛 다싯다 : 2000원");
				System.out.println("7.구입을 종료합니다");
				System.out.print(">>");
				String sel = scan.next();
				switch (sel) {
				case "1":
					System.out.println("떡볶이를 1개 구매합니다");
					Thread.sleep(100);
					if (tc.money < 3000) {
						System.out.println("금액이 부족합니다");
						Thread.sleep(100);
					} else {
						tc.money = tc.money - 3000;
						tock++;
					}
					break;
				case "2":
					System.out.println("고추장을 1개 구매합니다");
					Thread.sleep(100);
					if (tc.money < 5000) {
						System.out.println("금액이 부족합니다");
						Thread.sleep(100);
					} else {
						tc.money = tc.money - 5000;
						gochujang++;
					}
					break;
				case "3":
					System.out.println("어묵을 1개 구매합니다");
					Thread.sleep(100);
					if (tc.money < 5000) {
						System.out.println("금액이 부족합니다");
						Thread.sleep(100);
					} else {
						tc.money = tc.money - 5000;
						odeng++;
					}
					break;
				case "4":
					System.out.println("넓적당면을 1개 구매합니다");
					Thread.sleep(100);
					if (tc.money < 8000) {
						System.out.println("금액이 부족합니다");
						Thread.sleep(100);
					} else {
						tc.money = tc.money - 8000;
						dangmen++;
					}
					break;
				case "5":
					System.out.println("삶은 달걀을 1개 구매합니다");
					Thread.sleep(100);
					if (tc.money < 1000) {
						System.out.println("금액이 부족합니다");
						Thread.sleep(100);
					} else {
						tc.money = tc.money - 1000;
						egg++;
					}
					break;
				case "6":
					System.out.println("고양이맛 다싯다 1개 구매합니다");
					Thread.sleep(100);
					if (tc.money < 2000) {
						System.out.println("금액이 부족합니다");
						Thread.sleep(100);
					} else {
						tc.money = tc.money - 2000;
						dashida++;
					}
					break;
				case "7":
					break 종료;
				default:
					System.out.println("잘못입력하셨습니다");
					break;
				}

			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
