package com.example.designpattern.ChainOfResponsibility;

public class Trouble {

	private int number;

	public Trouble(int number) {
		super();
		this.number = number;
	}

	@Override
	public String toString() {
		return "Trouble [number=" + number + "]";
	}

	public int getNumber() {
		return number;
	}

}
