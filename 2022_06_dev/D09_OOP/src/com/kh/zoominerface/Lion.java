package com.kh.zoominerface;

public class Lion  extends Animal implements Perdator{

	@Override
	public String animalFood() {
		return "chicken";
	}
}
