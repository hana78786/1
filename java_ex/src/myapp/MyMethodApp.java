package myapp;

public class MyMethodApp {
	public static double valueOfSupply;
	public static double vatRate;
	public static double espeseRate;
public static void main(String[] args) {
	
	
	valueOfSupply= 10000;
	vatRate = 0.1;
	espeseRate = 0.3;
	double vat = getVAT();
	double totla = getTotal();
	double expense = getExpense();
	double income = getIncome();
	double dividend1 = getDividend1();
	double divideend2 = getDividend2();
	double dividend3 = getDividend3();
	
	print();
}

private static void print() {
	System.out.println("Value of supply : "+valueOfSupply);
	System.out.println("VAT : "+getVAT());
	System.out.println("Totla : "+getTotal());
	System.out.println("Expencse : "+getExpense());
	System.out.println("Income : "+getIncome());
	System.out.println("Dividend 1 : "+getDividend1());
	System.out.println("Dividend 2 : "+getDividend2());
	System.out.println("Dividend 3 : "+getDividend3());
}

private static double getDividend3() {
	return getIncome()*0.2;
}

private static double getDividend2() {
	return getIncome()*0.3;
}

private static double getDividend1() {
	return getIncome()*0.5;
}

private static double getIncome() {
	return valueOfSupply -getExpense();
}

private static double getExpense() {
	return valueOfSupply* espeseRate;
}

private static double getTotal() {
	return valueOfSupply+getVAT();
}

private static double getVAT() {
	return valueOfSupply*vatRate;
}
}
