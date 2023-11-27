package com.example.designpattern.Bridge;
/**
 * 类的实现层次结构：负责显示的类
 * @author shiker96
 *
 */
public abstract class DisplayImpl {

	public abstract void setStringAndWidth(String string);

	public abstract void rawOpen();

	public abstract void rawPrint();

	public abstract void rawClose();
}
