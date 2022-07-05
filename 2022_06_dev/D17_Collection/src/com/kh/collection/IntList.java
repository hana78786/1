package com.kh.collection;

public class IntList {
	private int[] nums;
	private int current;
	
	public IntList() {
		nums = new int[3];
		current = 0;
	}
	public void add(int input) {
		nums[current] = input;
		current++;
	}
	
	
	public int get(int index) {
		return nums[index];
		
		
		
	}
	
	public int size() {
		return current;
	}
	
	
	public void clear() {
		nums = new int[3];
		current = 0;
		
	}
}
