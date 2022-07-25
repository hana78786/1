package access.sample;

public class TestPoint {
public static void main(String[] args) {
	Point p1= new Point();
	Point p2= new Point(10,20);
	
	System.out.println("p1 : " + p1.getPosX()+","+p1.getPosY());
	System.out.println("p2 : "+ p2.getPosX()+","+p2.getPosY());
	
	p1.setPosX(12);
	p1.setPosY(23);
	System.out.println("p1 : "+p1.getPosX()+","+p1.getPosY());
}
}
