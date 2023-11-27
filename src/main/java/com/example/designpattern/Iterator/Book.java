package com.example.designpattern.Iterator;

import lombok.Data;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 通过getName获取书的名字
 * 
 * @author shiker96
 *
 */
@Component
@Data
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class Book {
	private String name;
}
