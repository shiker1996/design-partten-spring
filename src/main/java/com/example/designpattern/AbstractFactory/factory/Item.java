package com.example.designpattern.AbstractFactory.factory;
/**
 * 方便统一处理link和tray的类
 * @author shiker96
 *
 */

public abstract class Item {

	protected String caption;

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public abstract String makeHTML();
}
