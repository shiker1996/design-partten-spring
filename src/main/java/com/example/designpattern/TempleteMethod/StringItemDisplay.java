package com.example.designpattern.TempleteMethod;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class StringItemDisplay extends AbstractDisplay {

	private String string;
	private int width;

	public void initDisplay(String string) {
		this.string = string;
		this.width = string.getBytes().length;
	}

	@Override
	public void open() {
		// TODO Auto-generated method stub
		printLine();
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		log.info("|" + string + "|");
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		printLine();
	}

	private void printLine() {
		StringBuilder stringBuilder = new StringBuilder("+");
		for (int i = 0; i < width; i++) {
			stringBuilder.append("-");
		}
		stringBuilder.append("+");
		log.info(stringBuilder.toString());
	}

}
