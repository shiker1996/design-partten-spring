package com.example.designpattern.Prototype;

import com.example.designpattern.Prototype.framework.Product;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 现有实例（具体原型）1
 * @author shiker96
 *
 */

@Slf4j
@Setter
@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
public class MessageBox implements Product {

	private char decochar;

	@Override
	public void use(String s) {
		// TODO Auto-generated method stub
        int length = s.getBytes().length;
		StringBuilder sb = new StringBuilder();
        for(int i= 0;i<length+4;i++){
        	sb.append(decochar);
        }
		log.info(sb.toString());
		log.info(decochar+" "+s+" "+decochar);
		log.info(sb.toString());
        log.info(" ");
	}
}
