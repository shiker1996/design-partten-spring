package com.example.designpattern.Decorator;

import lombok.extern.slf4j.Slf4j;

/**
 * 用于显示字符串的抽象类
 * @author shiker96
 *
 */
@Slf4j
public abstract class Display {
	public abstract int getColumns();
	public abstract int getRows();
	public abstract String getRowText(int row);
	public final void show(){
		for(int i=0;i<getRows();i++){
			log.info(getRowText(i));
		}
	}
}
