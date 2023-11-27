package com.example.designpattern.AbstractFactory.listfactory;


import com.example.designpattern.AbstractFactory.factory.Link;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
public class ListLink extends Link {

	public String makeHTML(){
		return "<li><a href = \""+url+"\">"+caption+"</li>\n";
	}

}
