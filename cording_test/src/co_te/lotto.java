package co_te;

import java.util.Random;

public class lotto {

	public static void main(String[] args) {
		Random random = new Random();
		int[] rotto = new int[6];
		for (int i = 0; i < rotto.length; i++) {
			rotto[i] = random.nextInt(41) + 6;
			for (int j = 0; j < i; j++) {
				if (rotto[i] == rotto[j]) {
					i--;
				}
			}
		}
			
			for(int i=0; i<rotto.length-1;i++) {
				for(int j=0;j<rotto.length-1-i;j++) {
					if(rotto[j]>rotto[j+1]) {
						int temp = rotto[j+1];
						rotto[j+1] = rotto[j];
						rotto[j]= temp;
					}
					
					
				}
			}
			for(int i=0; i<rotto.length;i++) {
				System.out.println(rotto[i]);
			}
		}
	}

