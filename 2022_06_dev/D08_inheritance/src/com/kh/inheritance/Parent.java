package com.kh.inheritance;

public class Parent {
	protected int money = 2000;
	
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money+=money;
	}
	
	public void pizzaRecipe() {
		System.out.println("도우는 얇게 치즈는 많이");
	}
	
}
