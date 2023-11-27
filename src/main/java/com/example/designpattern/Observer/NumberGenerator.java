package com.example.designpattern.Observer;

import java.util.ArrayList;
import java.util.Iterator;
/**
 * 观察对象，注册观察者和删除观察者的方法
 * @author shiker96
 *
 */
public abstract class NumberGenerator {

	private ArrayList<Observer> observers = new ArrayList<Observer>();

	public void deleteObserver(Observer observer){
		observers.remove(observer);
	}
	public void addObserver(Observer observer){
		observers.add(observer);
	}
	public void notifyObservers(){
		Iterator< Observer> it = observers.iterator();
		while (it.hasNext()) {
			Observer o = (Observer) it.next();
			o.update(this);
		}
	}
	public abstract int getNumber();
	public abstract void execute();
}
