package com.example.designpattern.Decorator;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 用于显示单行字符串的类
 * @author shiker96
 *
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class StringDisplay extends Display {
	private String string;

	public void initStringDisplay(String string) {
		this.string = string;
	}

	@Override
	public int getColumns() {
		// TODO Auto-generated method stub
		return string.getBytes().length;
	}

	@Override
	public int getRows() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public String getRowText(int row) {
		// TODO Auto-generated method stub
		if (row == 0) {
			return string;
		} else {
			return null;
		}
	}

}
