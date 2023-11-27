package com.example.designpattern.Strategy;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@StrategyName(StrategyEnum.WINNING_STRATEGY)
public class WinningStrategy implements Strategy {
	private Random random;
	private boolean won = false;
	private Hand preHand;

	public void setRandom(int seed) {
		random = new Random(seed);
	}

	@Override
	public Hand nextHand() {
		// TODO Auto-generated method stub
		if (!won) {
			preHand = Hand.getHand(random.nextInt(3));
		}
		return preHand;
	}

	@Override
	public void study(boolean win) {
		// TODO Auto-generated method stub
		won = win;
	}

}
