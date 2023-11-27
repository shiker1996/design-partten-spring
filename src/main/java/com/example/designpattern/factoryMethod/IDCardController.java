package com.example.designpattern.factoryMethod;

import com.example.designpattern.factoryMethod.framework.Factory;
import com.example.designpattern.factoryMethod.framework.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class IDCardController {

	@Resource
	Factory factory;

	@GetMapping("factory")
	public void factory(){
		Product card1 = factory.create(123,"小明");
		Product card2 = factory.create(124,"小红");
		Product card3 = factory.create(125,"小刚");
		card1.use();
		card2.use();
		card3.use();
	}
}
