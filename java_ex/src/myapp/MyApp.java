package myapp;

public class MyApp {
public static void main(String[] args) {
	
	
	double valueOfSupply= Double.parseDouble(args[0]);
	double vatRate = 0.1;
	double espeseRate=0.3;
	double vat = valueOfSupply*vatRate;
	double totla = valueOfSupply+vat;
	double expense = valueOfSupply*espeseRate;
	double income = valueOfSupply -expense;
	double dividend1 = income*0.5;
	double divideend2 = income*0.3;
	double dividend3 = income*0.2;
	
	System.out.println("Value of supply : "+valueOfSupply);
	System.out.println("VAT : "+vat);
	System.out.println("Totla : "+totla);
	System.out.println("Expencse : "+expense);
	System.out.println("Income : "+income);
	System.out.println("Dividend 1 : "+dividend1);
	System.out.println("Dividend 2 : "+divideend2);
	System.out.println("Dividend 3 : "+dividend3);
}
}
