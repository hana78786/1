package oop;
class Acounting{
	 public double valueOfSupply;
	    // 부가가치세율
	    public static double vatRate = 0.1;
	 
	    public  double getVAT() {
	        return valueOfSupply * vatRate;
	    }
	     
	    public double getTotal() {
	        return valueOfSupply + getVAT();
	    }
	 
}

public class AcountingApp {
	
	public static void main(String[] args) {
	  	Acounting a1=new Acounting(); 	
   	a1.valueOfSupply=10000;
 
       Acounting a2=new Acounting(); 	
   	a2.valueOfSupply=20000;
      
       System.out.println("Value of supply : " + a1.valueOfSupply);
       System.out.println("Value of supply : " + a2.valueOfSupply);
       System.out.println("VAT : " + a1.getVAT());
       System.out.println("VAT : " + a2.getVAT());
       System.out.println("Total : " + a1.getTotal());
       System.out.println("Total : " + a2.getTotal());
       


	
	}
	}
	


