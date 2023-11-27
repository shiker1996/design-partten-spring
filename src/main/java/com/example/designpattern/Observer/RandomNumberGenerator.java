package com.example.designpattern.Observer;

import org.springframework.stereotype.Component;

import java.util.Random;
/**
 * 具体的观察对象，自身状态发生改变，会通知所有已经注册的观察者角色。
 * @author shiker96
 *
 */
@Component
public class RandomNumberGenerator extends NumberGenerator {

	private Random random  = new Random();
	private int number;
	@Override
	public int getNumber() {
		// TODO Auto-generated method stub
		return number;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
        for(int i=0;i<20;i++){
        	number = random.nextInt(50);
        	notifyObservers();
        }
	}

}
