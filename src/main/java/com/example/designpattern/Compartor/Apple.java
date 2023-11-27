package com.example.designpattern.Compartor;

public class Apple implements Comparable<Apple> {

	private int size;
	private int weight;
	
	public Apple(int size, int weight) {
		super();
		this.size = size;
		this.weight = weight;
	}

	public int getSize() {
		return size;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public int compareTo(Apple t) {
		// TODO Auto-generated method stub
		int m = this.size-t.size;
		int n = this.weight-t.weight;
		if(m>0&&n>0) return m;
		else return -Math.abs(m);
	}

	public boolean equals(Apple t) {
		// TODO Auto-generated method stub
		if(this.size==t.size&&this.weight==t.weight) return true;
		else return false;
	}
}
