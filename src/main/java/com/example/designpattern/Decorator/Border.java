package com.example.designpattern.Decorator;
/**
 * 用于显示装饰边框的抽象类
 * @author shiker96
 *
 */
public abstract class Border extends Display {
	protected Display display;

	protected void initBorder(Display display) {
		this.display = display;
	}
}
