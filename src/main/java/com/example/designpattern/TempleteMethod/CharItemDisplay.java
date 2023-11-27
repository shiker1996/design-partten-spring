package com.example.designpattern.TempleteMethod;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Slf4j
public class CharItemDisplay extends AbstractDisplay {

	private char ch;

	public void initDisplay(char ch) {
		this.ch = ch;
	}

	@Override
	public void open() {//显示开始字符
		// TODO Auto-generated method stub
		log.info("<<");
	}

	@Override
	public void print() {//打印字符
		// TODO Auto-generated method stub
		log.info(String.valueOf(ch));
	}

	@Override
	public void close() {//显示结束字符
		// TODO Auto-generated method stub
		log.info(">>");
	}

}
