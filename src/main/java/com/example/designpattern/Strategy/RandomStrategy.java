package com.example.designpattern.Strategy;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@StrategyName(StrategyEnum.RANDOM_STRATEGY)
public class RandomStrategy implements Strategy {
	private Random random;
	private Hand hand;

	public void setRandom(int seed) {
		random = new Random(seed);
	}

	@Override
	public Hand nextHand() {
		// TODO Auto-generated method stub
		hand = Hand.getHand(random.nextInt(3));
		return hand;
	}

	@Override
	public void study(boolean win) {
	}

}
