package sample;

public class TestOverriding {
	public static void main(String[] args) {
		Parent p = new Parent();
		p.display();
		
		Child c= new Child();
		c.out();
		c.display();
	}

}
