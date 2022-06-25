package sample;

public class PhoneMain {
public static void main(String[] args) {
	IPhone iphone = new IPhone("7","010-1111-1234",32);
	GPhone gphone = new GPhone("Vega","010-2222-2541");
	
	System.out.println(iphone.getModel() + "," + iphone.getNumber()+iphone.getMemorySize());;
	System.out.println(gphone.getModel()+","+gphone.getNumber()+","+gphone.getOs());
	
}
}
