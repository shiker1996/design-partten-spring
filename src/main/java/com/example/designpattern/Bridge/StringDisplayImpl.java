package com.example.designpattern.Bridge;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 类的实现层次结构：用字符串显示的类
 * @author shiker96
 *
 */
@Component
@Slf4j
public class StringDisplayImpl extends DisplayImpl {

	private String string;
	private int width;

	public void setStringAndWidth(String string){
		this.string = string;
		this.width = string.getBytes().length;
	}

	@Override
	public void rawOpen() {
		// TODO Auto-generated method stub
		printLine();
	}

	@Override
	public void rawPrint() {
		// TODO Auto-generated method stub
		log.info("|" + string + "|");
	}

	@Override
	public void rawClose() {
		// TODO Auto-generated method stub
		printLine();
	}

	private void printLine() {
		// TODO Auto-generated method stub
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("+");
		for (int i = 0; i < width; i++) {
			stringBuilder.append("-");
		}
		stringBuilder.append("+");
		log.info(String.valueOf(stringBuilder));
	}

}
