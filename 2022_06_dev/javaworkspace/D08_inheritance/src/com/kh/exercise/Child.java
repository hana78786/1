package com.kh.exercise;

import com.kh.inheritance.Parent;

public class Child extends Parent {
	int myMoney = 1000;
	int money = 3000;
	
//	public Child() {
//		super();
//	}

	public void printInfo() {
		System.out.println("child Money : " + this.money);
		System.out.println("Parent money : " + super.money);
		System.out.println("child myMoney : " + this.myMoney);
		super.pizzaRecipe();
	}
	
	
	//@override
	public void pizzaRecipe() {
		System.out.println("µµ¿ì´Â µÎ²®°í ÇÜÀ» ¸¹ÀÌ");
	}
}
