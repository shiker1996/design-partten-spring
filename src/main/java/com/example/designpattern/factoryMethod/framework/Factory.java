package com.example.designpattern.factoryMethod.framework;


import com.example.designpattern.factoryMethod.IDcard;

/**
 * 适用模板模式，声明了生成产品的方法和注册产品的抽象方法
 * @author lenovo
 *
 */
public abstract class Factory {

	/**
	 * 工厂模式在生成实例时调用了模板方法模式
	 * @param owner
	 * @return
	 */
	public final Product create(int ID,String owner) {
		Product p = createProduct(ID,owner);//生产产品
		registerProduct(p);//注册产品
		return p;//返回产品对象
	}

	//定义生成实例的方法为抽象方法，生成相应的具体工厂时必须重写该方法
	protected abstract IDcard createProduct(int ID, String owner);

	protected abstract void registerProduct(Product product);
}
