package com.example.designpattern.Flyweight;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 使用轻量级工厂生成轻量级角色
 * @author shiker96
 *
 */
@Component
public class BigString {

	private BigChar[] bigchars;

	@Resource
	private BigCharFactory factory;

	public void initBigString(String string) {
		bigchars = new BigChar[string.length()];
		for(int i =0 ;i<bigchars.length;i++){
			bigchars[i] = factory.getBigChar(string.charAt(i));
		}
	}
	
	public void print(){
		for(int i=0;i<bigchars.length;i++){
			bigchars[i].print();
		}
	}
}
