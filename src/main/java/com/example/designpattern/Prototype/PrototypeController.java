package com.example.designpattern.Prototype;

import com.example.designpattern.Prototype.framework.Manager;
import com.example.designpattern.Prototype.framework.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PrototypeController {

	@Resource
	Manager manager;

	@GetMapping("prototype")
	public void prototype(String msgType, String msg){
		//生成，根据现有实例生成新实例
		Product p1 = manager.create(msgType);
		p1.use(msg);
	}
}
