package com.example.designpattern.Builder;

import com.example.designpattern.Builder.framework.Builder;
import com.example.designpattern.Builder.framework.BuilderName;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BuilderGenerator {
	@Resource
	private List<Builder> builders;
	private Map<String, Builder> builderMap = new HashMap<>();


	public Builder getBuilder(String builderName){
		return builderMap.get(builderName);
	}

	@PostConstruct
	public void initBuilder(){
		for(Builder builder: builders){
			builderMap.put(builder.getClass().getAnnotation(BuilderName.class).value(), builder);
		}
	}
}
