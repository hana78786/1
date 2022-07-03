package make.topokki;

public class text {
	public static void main(String[] args) {
		GameIn gi = new GameIn();
		gi.quiz_random();
		for (int i = 0; i < 10; i++) {
			System.out.println(gi.quizNum[i]);
  
			
		}
	}
}
