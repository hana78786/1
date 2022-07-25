package com.kh.collection;

import java.util.Objects;

public class ObjectList {
	private Object[] objects;
	private int current;
	
	public ObjectList(){
		objects = new Objects[3];
		current = 0;
	}
	
	public void add(Object input) {
		objects[current] = input;
		current++;
	}
	public Object get(int index) {
		return objects[index];
	}
	
	public int size() {
		return current;
	}
	
	public void clear() {
		objects = new Object[3];
		current = 0;
	}
	
	
}
