package com.example.designpattern.Strategy;

public interface Strategy {

	Hand nextHand();
	void study(boolean win);

	void setRandom(int seed);
}
