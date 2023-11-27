package com.example.designpattern.Compartor;

public interface Comparator<T> {

	public abstract int compact(T a,T b);
	
	public abstract boolean equals(T a,T b);
}
