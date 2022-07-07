package make.topokki1;

public class Player {
	
	private int money = 1000;
	private int gameMoney = 0;
	private String Ox;
	private String[] quizNum = new String[10];
	private boolean[] quizAnswer = new boolean[10];
	
	
	
	
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getGameMoney() {
		return gameMoney;
	}
	public void setGameMoney(int gameMoney) {
		this.gameMoney = gameMoney;
	}
	public String getOx() {
		return Ox;
	}
	public void setOx(String ox) {
		Ox = ox;
	}
	public String[] getQuizNum() {
		return quizNum;
	}
	public void setQuizNum(String[] quizNum) {
		this.quizNum = quizNum;
	}
	public boolean[] getQuizAnswer() {
		return quizAnswer;
	}
	public void setQuizAnswer(boolean[] quizAnswer) {
		this.quizAnswer = quizAnswer;
	}

	

	
	

}
