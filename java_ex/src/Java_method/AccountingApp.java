package Java_method;

public class AccountingApp {
	public static double valueOfSupply=10000.0;
	public static double vatRate=0.1;
	
	public static void main(String[] args) {
		
	
		double vat=getVat();
		double total = total();
		
		System.out.println("Value of supply : "+valueOfSupply);
		System.out.println("VAT : "+getVat());
		System.out.println("Totla : "+ total());
	}

	public static double total() {
		double total=valueOfSupply+getVat();
		return total;
	}

	public static double getVat() {
		return valueOfSupply * vatRate;
	}

}
