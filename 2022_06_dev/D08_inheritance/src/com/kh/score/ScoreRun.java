package com.kh.score;

import java.util.Scanner;

public class ScoreRun {
	public static void main(String[] args) {
		ScoreFunction sFunc= new ScoreFunction();
		
		Scanner sc = new Scanner(System.in);
		���� : while (true) {
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
				System.out.println("�����մϴ�");
				break ����;
			default: System.out.println("�߸��Է��ϼ̽��ϴ�.");
				break;
			}
		}
	}
}
