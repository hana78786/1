package myapp;

class Acounting{
public  double valueOfSupply;
public  double vatRate;
public  double espeseRate;

double vat = getVAT();
double totla = getTotal();
double expense = getExpense();
double income = getIncome();
double dividend1 = getDividend1();
double divideend2 = getDividend2();
double dividend3 = getDividend3();

void print() {
	System.out.println("Value of supply : "+valueOfSupply);
	System.out.println("VAT : "+getVAT());
	System.out.println("Totla : "+getTotal());
	System.out.println("Expencse : "+getExpense());
	System.out.println("Income : "+getIncome());
	System.out.println("Dividend 1 : "+getDividend1());
	System.out.println("Dividend 2 : "+getDividend2());
	System.out.println("Dividend 3 : "+getDividend3());
}

private double getDividend3() {
	return getIncome()*0.2;
}

private double getDividend2() {
	return getIncome()*0.3;
}

private double getDividend1() {
	return getIncome()*0.5;
}

private double getIncome() {
	return valueOfSupply -getExpense();
}

private double getExpense() {
	return valueOfSupply* espeseRate;
}

private double getTotal() {
	return valueOfSupply+getVAT();
}

private double getVAT() {
	return valueOfSupply*vatRate;
}
}


public class MyClassApp {

public static void main(String[] args) {

	Acounting a1=new Acounting();
	a1.valueOfSupply= 10000;
	a1.vatRate = 0.1;
	a1.espeseRate = 0.3;
	a1.print();
	System.out.println();
	
	Acounting a2=new Acounting();
	a2.valueOfSupply= 20000;
	a2.vatRate = 0.2;
	a2.espeseRate = 0.5;
	a2.print();
			
}}
