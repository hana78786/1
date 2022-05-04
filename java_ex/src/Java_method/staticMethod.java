package Java_method;

class print{
	public String del;
public void b() {
	System.out.println(this.del);
	System.out.println("b");
	System.out.println("b");
	
}

public void a() {
	System.out.println(this.del);
	System.out.println("a");
	System.out.println("a");
	
}
}

public class staticMethod {

	public static void main(String[] args) {
	print p1=new print();
	p1.del="-";
	p1.a();
	p1.b();
	
	print p2=new print();
	p2.del="*";
	p2.a();
	p2.b();
	
	
	}

	

}
