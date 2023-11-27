package com.example.designpattern.Composite;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
@Slf4j
public class File extends Entry {

	private String name;
	private int size;

	public void initEntry(String name, int size){
		this.name = name;
		this.size = size;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	protected void printList(String prefix) {
		// TODO Auto-generated method stub
		log.info(prefix + "/" + this);
	}

}
