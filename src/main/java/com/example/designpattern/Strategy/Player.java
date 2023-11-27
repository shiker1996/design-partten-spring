package com.example.designpattern.Strategy;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class Player {

	private String name;
	private Strategy strategy;
	private int wincount;
	private int losecount;
	private int gamecount;
	public void init(String name, Strategy strategy) {
		this.name = name;
		this.strategy = strategy;
	}
	public Hand nextHand(){
		return strategy.nextHand();
	}
	public void win(){
		strategy.study(true);
		wincount++;
		gamecount++;
	}
	public void lose(){
		strategy.study(false);
		losecount++;
		gamecount++;
	}
	public void even(){
		gamecount++;
	}
	@Override
	public String toString() {
		return "Player [name=" + name + ", strategy=" + strategy
				+ ", wincount=" + wincount + ", losecount=" + losecount
				+ ", gamecount=" + gamecount + "]";
	}
}
	
