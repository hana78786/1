package sample1;

public class Buyer {
	int money = 500;
	
	public void buy (Furniutre f) {
		if(money<f.price) {
			System.out.println("잔액부족!");
			return;
			
		}
		money -=f.price;
		System.out.println(f+"구매성공! 잔액"+money+"만원");
	}

}
