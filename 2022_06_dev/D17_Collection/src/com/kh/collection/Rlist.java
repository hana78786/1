package com.kh.collection;

public class Rlist<T> {
	private Object [] objets;
	private int current;
	
	public Rlist() {
		objets = new Object[3];
		current =0 ;
	
	}
	
	public void add(T input) {
		objets[current]=input;
		current++;
		
	}

	public T get(int index) {
		return(T)objets[index];
	}
	
	public int size() {
		return current;
	}
	
	public void clear() {
		objets = new Object[3];
		current =0;
	}
	
	
}
