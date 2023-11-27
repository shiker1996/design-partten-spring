package com.example.designpattern.Visitor;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 表示文件的类
 * @author shiker96
 *
 */

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class VFile extends Entry {
    private String name;
    private int size;
    
	public void initFile(String name, int size) {
		this.name = name;
		this.size = size;
	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
        v.visit(this);
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

}
