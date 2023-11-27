package com.example.designpattern.Prototype.framework;

import java.util.HashMap;
/**
 * 创建原型名称与原型类的集合
 * @author shiker96
 *
 */
public class Manager {

	private HashMap<String, Product> showcase = new HashMap<String, Product>();
	//将相应的原型名称与原型注册到集合中
	public void register(String name,Product proto){
		showcase.put(name, proto);
	}
	//根据不同的原型名称获取相应的原型
	public Product create(String proroname){
		Product p = showcase.get(proroname);
		return p;
	}
}
