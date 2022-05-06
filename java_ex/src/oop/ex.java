
package oop;

class count{
	double money;
	public count(double money) {
		this.money=money;
	}
	double gas=getgas();
	public double getgas() {
		return money/5;
	}
	double cat=getcat();
	public double getcat() {
		return money*0.5;
		
	}
	double minus=getminus();
	public double getminus() {
		return getcat()+getgas();
	}


}

public class ex {
	public static void main(String[] args) {
		count co=new count(10000);

		System.out.println("월급:"+co.money);
		System.out.println("가스비:"+co.getgas());
		System.out.println("고양이 비용:"+co.getcat());
		System.out.println("지출비용"+co.getminus());
		
count co1=new count(50000);
		
		System.out.println("월급:"+co1.money);
		System.out.println("가스비:"+co1.getgas());
		System.out.println("고양이 비용:"+co1.getcat());
		System.out.println("지출비용"+co1.getminus());		
		
	}

}
