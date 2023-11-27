package com.example.designpattern.Observer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 具体的观察者。获取观察对象的最新状态
 * @author shiker96
 *
 */
@Component
@Slf4j
public class DigitObserver implements Observer {
	@Override
	public void update(NumberGenerator generator) {
		// TODO Auto-generated method stub
		log.info("DigitObserver:"+generator.getNumber());
		try{
			Thread.sleep(100);
		}catch(InterruptedException e){
			
		}
	}

}
