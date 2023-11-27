package com.example.designpattern.AbstractFactory;

import com.example.designpattern.AbstractFactory.factory.Factory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AbstractFactoryGenerator  {


	@Resource
	private List<Factory> factories;

	private Map<String, Factory> factoryMap = new HashMap<>();

	public Factory getFactory(String factoryName){
		return factoryMap.get(factoryName);
	}

	public boolean isSupportFactory(String name){
		return factoryMap.containsKey(name);
	}

	@PostConstruct
	public void initMap(){
		for (Factory factory: factories){
			factoryMap.put(factory.getName(), factory);
		}
	}

}
