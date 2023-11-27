package com.example.designpattern.factoryMethod;

import com.example.designpattern.factoryMethod.framework.Factory;
import com.example.designpattern.factoryMethod.framework.Product;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 子类实现父类中的抽象方法，即ID cardfactory通过 继承factory并重写创建对象与注册对象的方法生成 相应的id对象
 * 
 * @author shiker96
 *
 */
@Service
public class IDCardFactory extends Factory {

	@Resource
	IDCardGenerator iDcardGenerator;

	private Map<Integer, String> owners = new HashMap<Integer, String>();

	@Override
	protected IDcard createProduct(int ID, String owner) {
		// TODO Auto-generated method stub
		IDcard iDcard =iDcardGenerator.iDcard();
		iDcard.setID(ID);
		iDcard.setOwner(owner);
		return iDcard;
	}

	/**
	 * 通过将IDcard的持有人保存到owners中完成注册
	 */
	@Override
	protected void registerProduct(Product product) {
		// TODO Auto-generated method stub
		owners.put(((IDcard) product).getID(), ((IDcard) product).getOwner());
	}

	public Map<Integer, String> getOwners() {
		return owners;
	}
}
