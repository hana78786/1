package Java_method;

class pirnt{
	public String del;
	public void b() {
		System.out.println(this.del);
		System.out.println("b");
	}

	public void a() {
		System.out.println(this.del);
		System.out.println("a");
		
	}

public static void c(String del) {
	System.out.println(del);
	System.out.println("c");
}
}
public class staticMethodes {

	public static void main(String[] args) {
		
		print p1=new print();
		p1.del="*";
		p1.a();
		p1.b();
		
		pirnt.c("--");
	}

	

}
