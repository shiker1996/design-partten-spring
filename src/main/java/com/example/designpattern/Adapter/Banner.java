package com.example.designpattern.Adapter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 实际情况
 * @author shiker96
 *
 */
@Component
@Slf4j
public class Banner {

	private String string;

	public void setString(String string) {
		this.string = string;
	}

	public void showWithParen(){
		log.info("("+string+")");
	}
	
	public void showWithAster(){
		log.info("*"+string+"*");
	}
}
