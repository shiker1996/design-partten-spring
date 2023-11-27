package com.example.designpattern.ChainOfResponsibility;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
public class SpecialSupport extends Support {

	private int number;

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	protected void setName(String name) {
		super.setName(name);
	}

	@Override
	protected boolean resolve(Trouble trouble) {
		// TODO Auto-generated method stub
		if(trouble.getNumber()==number){
			return true;
		}else{
			return false;
		}
	}

}
