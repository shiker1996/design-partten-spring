package com.example.designpattern.Bridge;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 类的功能层次结构：负责显示的类
 * @author shiker96
 *
 */
@Component
public class Display {

	@Resource
	private DisplayImpl impl;

	public void setImpl(String string){
		impl.setStringAndWidth(string);
	}

	public void open() {
		impl.rawOpen();
	}

	public void print() {
		impl.rawPrint();
	}

	public void close() {
		impl.rawClose();
	}

	public final void display() {
		open();
		print();
		close();
	}
}
