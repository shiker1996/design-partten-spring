package com.example.designpattern.Compartor;

public class MyCompator implements Comparator<Apple>{

	@Override
	public int compact(Apple a, Apple b) {
		// TODO Auto-generated method stub
		int m = a.getSize()-b.getSize();
		int n = a.getWeight()-b.getWeight();
		if(m>0&&n>0) return n;
		else return -Math.abs(n);
	}

	@Override
	public boolean equals(Apple a, Apple b) {
		// TODO Auto-generated method stub
		if(a.getSize()==b.getSize()&&a.getWeight()==b.getWeight()) return true;
		else return false;
	}

}
