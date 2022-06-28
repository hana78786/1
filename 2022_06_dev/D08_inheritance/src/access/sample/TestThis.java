package access.sample;

public class TestThis {
public static void main(String[] args) {
	Point1 p= new Point1(); 
	Point1 p1= new Point1(1010,200); 
	
	System.out.println(p.getPosX());
	System.out.println(p.getPosY());
	System.out.println(p1.getPosX());
	System.out.println(p1.getPosY());
}
}
