package com.example.designpattern.Decorator;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 用于只显示左右边框的类
 * @author shiker96
 *
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class SideBorder extends Border{

	private char borderChar;
	public void initSideBorder(Display display,char ch) {
		initBorder(display);
		// TODO Auto-generated constructor stub
		this.borderChar = ch;
	}

	@Override
	public int getColumns() {
		// TODO Auto-generated method stub
		return 1+display.getColumns()+1;
	}

	@Override
	public int getRows() {
		// TODO Auto-generated method stub
		return display.getRows();
	}

	@Override
	public String getRowText(int row) {
		// TODO Auto-generated method stub
		return borderChar+display.getRowText(row)+borderChar;
	}

}
