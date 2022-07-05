package make.qeen;

public class Scheculer1 {


	int money = 200;
	int power;
	int music;
	int cook;
	int strong;
	int manner;
	int art;
	int freindly;
	int study;
	int stress;

	// 아르바이트
	int farm;
	int cafe;
	int child;

	// 교육
	int martial;
	int artSchool;
	int musicSchool;
	


	public void farm() {// 농장알바
		System.out.println("--------------------");
		try {
			Thread.sleep(500);

		if (stress >= 100) {// 스트레스가 높으면 강제 휴식
			System.out.println("스트레스가 너무 높습니다");
			System.out.println("이번 스케줄은 휴식합니다.");
			Thread.sleep(500);
			rest();

		} else {
			power += 2;
			strong += 2;
			money += 20;
			farm++;
			

			System.out.println("힘이 2 증가했습니다.");
			System.out.println("근성이 2 증가했습니다.");
			System.out.println("돈이 20g 증가했습니다.");
			Thread.sleep(500);

			stress += 5;
			System.out.println("--------------------");

		}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void cafe() {// 식당알바
		System.out.println("--------------------");
		try {
			Thread.sleep(500);

			if (stress >= 100) {// 스트레스가 높으면 강제 휴식
				System.out.println("스트레스가 너무 높습니다");
				System.out.println("이번 스케줄은 휴식합니다.");
				Thread.sleep(500);
				rest();
			} else {
				cook += 2;
				strong += 2;
				money += 15;
				cafe++;
				stress += 5;

				System.out.println("요리가 2 증가했습니다.");
				System.out.println("근성이 2 증가했습니다.");
				System.out.println("돈이 15g 증가했습니다.");
				Thread.sleep(500);

				System.out.println("--------------------");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void child() {// 보모알바
		System.out.println("--------------------");
		try {
			Thread.sleep(500);

			if (stress >= 100) {// 스트레스가 높으면 강제 휴식
				System.out.println("스트레스가 너무 높습니다");
				System.out.println("이번 스케줄은 휴식합니다.");
				Thread.sleep(500);
				rest();
			} else {
				strong += 2;
				manner += 1;
				study += 1;
				money += 15;
				child++;

				stress += 5;

				System.out.println("힘이 2 증가했습니다.");
				System.out.println("예절이 1 증가했습니다.");
				System.out.println("학력이 1 증가했습니다.");
				System.out.println("돈이 15g 증가했습니다.");
				Thread.sleep(500);
				System.out.println("--------------------");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void artschool() {// 미술공부
		System.out.println("--------------------");
		try {
			Thread.sleep(500);

			if (stress >= 100) {// 스트레스가 높으면 강제 휴식
				System.out.println("스트레스가 너무 높습니다");
				System.out.println("이번 스케줄은 휴식합니다.");
				Thread.sleep(500);
				rest();
			} else {

				if (money < 50) {// 돈이 부족하면 강제 휴식
					System.out.println("돈이 부족합니다.");
					System.out.println("이번 스케쥴은 휴식합니다.");
					Thread.sleep(500);
					rest();

				} else {
					art += 5;
					study += 2;
					strong += 2;
					money -= 50;

					artSchool++;

					stress += 5;
					System.out.println("미술이 5 증가했습니다.");
					System.out.println("학력이 2 증가했습니다");
					System.out.println("힘이 2 증가했습니다");
					System.out.println("돈이 50g 감소했습니다");
					Thread.sleep(500);

					System.out.println("--------------------");

				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void musicschool() {// 음악공부
		System.out.println("--------------------");
		try {
			Thread.sleep(500);

			if (stress >= 100) {// 스트레스가 높으면 강제 휴식
				System.out.println("스트레스가 너무 높습니다");
				System.out.println("이번 스케줄은 휴식합니다.");
				Thread.sleep(500);
				rest();
			} else {
				if (money < 50) {// 돈이 부족하면 강제 휴식
					System.out.println("돈이 부족합니다.");
					System.out.println("이번 스케쥴은 휴식합니다.");
					Thread.sleep(500);
					rest();

				} else {
					music += 5;

					study += 2;

					manner += 2;

					money -= 50;

					musicSchool++;
					stress += 5;
					System.out.println("음악이 5 증가했습니다.");
					System.out.println("학력이 2 증가했습니다");
					System.out.println("예절이 2 증가했습니다");
					System.out.println("돈이 50g 감소했습니다");
					Thread.sleep(500);
					System.out.println("--------------------");
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void martial() {// 무술공부
		System.out.println("--------------------");
		try {
			Thread.sleep(500);
			if (stress >= 100) {// 스트레스가 높으면 강제 휴식
				System.out.println("스트레스가 너무 높습니다");
				System.out.println("이번 스케줄은 휴식합니다.");
				Thread.sleep(500);
				rest();
			} else {
				if (money < 50) {// 돈이 부족하면 강제 휴식
					System.out.println("돈이 부족합니다.");
					System.out.println("이번 스케쥴은 휴식합니다.");
					Thread.sleep(500);
					rest();

				} else {
					power += 5;

					strong += 2;

					study += 2;

					money -= 50;

					martial++;

					stress += 5;
					System.out.println("힘이 5 증가했습니다.");
					System.out.println("학력이 2 증가했습니다");
					System.out.println("근성이 2 증가했습니다");
					System.out.println("돈이 50g 감소했습니다");
					Thread.sleep(500);
					System.out.println("--------------------");

				}
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void rest() {// 휴식

		System.out.println("--------------------");
		try {
			Thread.sleep(500);
			System.out.println("휴식을 진행합니다.");
			System.out.println("스트레스가 20감소합니다.");
			stress -= 20;
			if (stress <= 0) {
				stress = 0;
			}
			System.out.println("--------------------");
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
