package myapp;

public class MyApparray {
public static void main(String[] args) {
	
	
	double valueOfSupply= Double.parseDouble(args[0]);
	double vatRate = 0.1;
	double espeseRate=0.3;
	double vat = valueOfSupply*vatRate;
	double totla = valueOfSupply+vat;
	double expense = valueOfSupply*espeseRate;
	double income = valueOfSupply -expense;
	

	
	double[] dividendrates = new double[3];
	dividendrates[0] = 0.5;
	dividendrates[1] = 0.3;
	dividendrates[2] = 0.2;
	
	
	double dividend1 = income*dividendrates[0];
	double divideend2 = income*dividendrates[1];
	double dividend3 = income*dividendrates[2];
	
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
