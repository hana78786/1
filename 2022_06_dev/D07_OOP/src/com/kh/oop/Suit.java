package com.kh.oop;

public class Suit {
	private int size;
	private String brand;
	private int price;

	
	public Suit() {}
	
	public Suit(int size) {
		this(size, "Hazzys");
		System.out.println(1); // (1)
	}

	public Suit(int size, String brand) {
		this(size, brand, 100000);
		System.out.println(2); // (2)
	}

	public Suit(int size, String brand, int price) {
		this.size = size;
		this.brand = brand;
		this.price = price;
		System.out.println(size + brand + price);// (3)
	}
}
