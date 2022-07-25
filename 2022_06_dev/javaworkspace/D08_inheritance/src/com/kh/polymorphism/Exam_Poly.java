package com.kh.polymorphism;

public class Exam_Poly {
	public static void main(String[] args) {
		// up-casting
		Car ca = new Sonata();
		ca.move(10);
		ca.stop();
		// Down-casting
		((Sonata)ca).moveSonata();
		
		
		int[] nums=new int[3];
		nums[0]=10;
		nums[1]=20;
		nums[2]=30;
		
		boolean[] bools = new boolean[3];
		bools[0] = true;
		bools[1] = false;
		bools[2] = true;
		
		String [] words = new String[3];
		words[0] = "Hello";
		words[1] = "java";
		words[2] = "GoodBye";
		
		Car[] cars = new Car[5]; //up-casting
		cars[0] = new Sonata();
		cars[1] = new Car();
		cars[2] = new Car();
		cars[3] = new Car();
		cars[4] = new Car();
		
		Sonata[] sonatas = new Sonata[3];
		sonatas[0] = new Sonata();
		sonatas[2] = new Sonata();
		

	}
}
