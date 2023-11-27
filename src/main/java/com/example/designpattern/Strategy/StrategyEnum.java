package com.example.designpattern.Strategy;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StrategyEnum {

	RANDOM_STRATEGY(),
	WINNING_STRATEGY(),
	PROB_STRATEGY()
}
