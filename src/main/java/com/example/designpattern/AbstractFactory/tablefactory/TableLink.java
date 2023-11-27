package com.example.designpattern.AbstractFactory.tablefactory;

import com.example.designpattern.AbstractFactory.factory.Link;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
public class TableLink extends Link {

	public String makeHTML(){
		return "<td><a href=\""+url+"\">"+caption +"</a></td>\n";
	}
}
