package sample1;

public class Buyer {
	int money = 500;
	
	public void buy (Furniutre f) {
		if(money<f.price) {
			System.out.println("�ܾ׺���!");
			return;
			
		}
		money -=f.price;
		System.out.println(f+"���ż���! �ܾ�"+money+"����");
	}

}
