package com.example.designpattern.Prototype;

import com.example.designpattern.Prototype.framework.Product;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 现有实例（具体原型）2
 * @author shiker96
 *
 */
@Slf4j
@Setter
@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
public class UnderLinePen implements Product {

	private char ulchar;

	@Override
	public void use(String s) {
		int length = s.getBytes().length;
		log.info("\"" + s + "\"");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length+2; i++) {
			sb.append(ulchar);
		}
		log.info(sb.toString());
		log.info(" ");
	}
}
