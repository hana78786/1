package myapp;

public class MyApparraroop2 {
public static void main(String[] args) {
	
	
	double valueOfSupply= Double.parseDouble(args[0]);
	double vatRate = 0.1;
	double espeseRate=0.3;
	double vat = valueOfSupply*vatRate;
	double totla = valueOfSupply+vat;
	double expense = valueOfSupply*espeseRate;
	double income = valueOfSupply -expense;
	


	
	System.out.println("Value of supply : "+valueOfSupply);
	System.out.println("VAT : "+vat);
	System.out.println("Totla : "+totla);
	System.out.println("Expencse : "+expense);
	System.out.println("Income : "+income);
	
	double[] dividendrates = new double[3];
	dividendrates[0] = 0.5;
	dividendrates[1] = 0.3;
	dividendrates[2] = 0.2;
	
	
	double dividend1 = income*dividendrates[0];
	double divideend2 = income*dividendrates[1];
	double dividend3 = income*dividendrates[2];
	
	
	int i =0;
	while(i<dividendrates.length){
		System.out.println("Dividend"+(i+1)+" : "+income*dividendrates[i]);
		i=i+1;
}
}}
