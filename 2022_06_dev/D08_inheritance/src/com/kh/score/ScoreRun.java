package com.kh.score;

import java.util.Scanner;

public class ScoreRun {
	public static void main(String[] args) {
		ScoreFunction sFunc= new ScoreFunction();
		
		Scanner sc = new Scanner(System.in);
		종료 : while (true) {
			sFunc.printMainMenu();
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				sFunc.insertScore();
				break;
			case 2:
				sFunc.printScore();
				break;
			case 3:
				System.out.println("종료합니다");
				break 종료;
			default: System.out.println("잘못입력하셨습니다.");
				break;
			}
		}
	}
}
