package com.example.designpattern.Memento.game;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
/**
 * 生成者，表示游戏状态的类
 * @author shiker96
 *
 */
@Component
@Slf4j
public class Gamer {

	@Getter
	@Setter
	private int money;
	private List<String> fruits = new ArrayList<String>();
	private Random random = new Random();
	@Resource
	private MementoGenerator mementoGenerator;

	private static String[] fruitsname = { "苹果", "葡萄", "香蕉", "橘子", };
	
	public void bet(){
		int dice = random.nextInt(6)+1;
		if(dice==1){
			money+=100;
			log.info("所持金钱增加了");
		}else if(dice==2){
			money/=2;
			log.info("所持金钱减半了");
		}else if(dice==6){
			String f = getFruit();
			log.info("获得了水果（"+f+")。");
			fruits.add(f);
		}else{
			log.info("什么都没发生");
		}
	}

	private String getFruit() {
		// TODO Auto-generated method stub
		String prefix = "";
		if(random.nextBoolean()){
			prefix="好吃的";
		}
		return prefix+fruitsname[random.nextInt(fruitsname.length)];
	}
	public Memento createMemento(){
		Memento m = mementoGenerator.genMemento(money);
		Iterator<String> it = fruits.iterator();
		while(it.hasNext()){
			String f = it.next();
			if(f.startsWith("好吃的")){
				m.addFruit(f);
			}
		}
		return m;
	}
	public void restoreMemento(Memento memento){
		this.money = memento.money;
		this.fruits = memento.getFruits();
	}

	@Override
	public String toString() {
		return "Gamer [money=" + money + ", fruits=" + fruits + ", random="
				+ random + "]";
	}
	
}
