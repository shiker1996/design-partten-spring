package com.example.designpattern.Memento.game;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
/**
 * 纪念品，将生成者的内部信息整合在 一起
 * @author shiker96
 *
 */
@Component
public class Memento {

	int money;
	ArrayList<String> fruits;
	public int getMoney() {
		return money;
	}
	
	public void initMemento(int money) {
		this.money = money;
		this.fruits = new ArrayList<String>();
	}

	void addFruit(String fruit){
		fruits.add(fruit);
	}
	
	public List<String> getFruits() {
		return (List<String>)fruits.clone();
	}
	
}
