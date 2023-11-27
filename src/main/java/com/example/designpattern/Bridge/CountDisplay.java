package com.example.designpattern.Bridge;

import org.springframework.stereotype.Component;

/**
 * 类的功能层次结构：增加了只显示规定次数这一功能。
 * @author shiker96
 *
 */
@Component
public class CountDisplay extends Display {

	public void mutiDIsplay(int times){
		open();
		for (int i = 0; i < times; i++) {
			print();
		}
		close();
	}

}
