package com.example.designpattern.ChainOfResponsibility;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
public class LimitSupport extends Support {

	private int limit;

	public void setLimit(int limit) {
		this.limit = limit;
	}

	@Override
	protected void setName(String name) {
		super.setName(name);
	}

	@Override
	protected boolean resolve(Trouble trouble) {
		// TODO Auto-generated method stub
		if(trouble.getNumber()<limit){
			return true;
		}else{
			return false;
		}
	}

}
