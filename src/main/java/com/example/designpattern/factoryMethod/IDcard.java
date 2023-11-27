package com.example.designpattern.factoryMethod;

import com.example.designpattern.factoryMethod.framework.Product;
import lombok.Data;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
public class IDcard extends Product {

	private int ID;
	private String owner;

	@Override
	public void use() {
		// TODO Auto-generated method stub
		System.out.println("使用" + owner +"::"+ID+ "的ID卡");
	}
	
}
