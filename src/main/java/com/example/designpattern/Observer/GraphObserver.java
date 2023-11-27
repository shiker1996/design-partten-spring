package com.example.designpattern.Observer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class GraphObserver implements Observer {

	@Override
	public void update(NumberGenerator generator) {
		// TODO Auto-generated method stub
        StringBuilder stringBuilder = new StringBuilder("GraphObserver:");
        int count = generator.getNumber();
        for(int i=0;i<count;i++){
	        stringBuilder.append("*");
        }
		log.info(stringBuilder.toString());
        try{
        	Thread.sleep(100);
        }catch(InterruptedException e){
        	
        }
	}

}
