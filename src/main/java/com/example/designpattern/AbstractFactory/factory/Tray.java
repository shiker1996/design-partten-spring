package com.example.designpattern.AbstractFactory.factory;

import java.util.ArrayList;
/**
 * 表示tray
 * @author shiker96
 *
 */
public abstract class Tray extends Item {
	protected ArrayList<Item> tray = new ArrayList<Item>();

	public void build(String caption){
		setCaption(caption);
	}
    
	public void add(Item item){
		tray.add(item);
	}
}
