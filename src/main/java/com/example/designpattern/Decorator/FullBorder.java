package com.example.designpattern.Decorator;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 用于显示上下左右边框的类
 * @author shiker96
 *
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class FullBorder extends Border{

	protected void initFullBorder(Display display) {
		initBorder(display);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getColumns() {
		// TODO Auto-generated method stub
		return 1+display.getColumns()+1;
	}

	@Override
	public int getRows() {
		// TODO Auto-generated method stub
		return 1+display.getRows()+1;
	}

	@Override
	public String getRowText(int row) {
		// TODO Auto-generated method stub
		if(row==0){
			return "+"+makeLine('-',display.getColumns())+"+";
		}else if(row == display.getRows()+1){
			return "+"+makeLine('-', display.getColumns())+"+";
		}else{
			return "|"+display.getRowText(row-1)+"|";
		}
	}

	private String makeLine(char ch,int count){
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < count; i++) {
			buf.append(ch);
		}
		return buf.toString();
	}
	
}
