package com.example.designpattern.Strategy;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public abstract class StrategyGenerator {

	@Lookup
	protected abstract Player player();
	@Resource
	private List<Strategy> strategyList;

	private Map<StrategyEnum, Strategy> strategyMap = new HashMap<>();

	public Player genPlayer(String username, StrategyEnum strategyEnum, int seed){
		Player player = player();
		Strategy strategy = strategyMap.get(strategyEnum);
		strategy.setRandom(seed);
		player.init(username, strategy);
		return player;
	}

	@PostConstruct
	public void initMap(){
		for (Strategy strategy: strategyList){
			strategyMap.put(strategy.getClass().getAnnotation(StrategyName.class).value(), strategy);
		}
	}
}
