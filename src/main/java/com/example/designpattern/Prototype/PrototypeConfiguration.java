package com.example.designpattern.Prototype;

import com.example.designpattern.Prototype.framework.Manager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class PrototypeConfiguration {

	@Resource
	private PrototypeGenerator prototypeGenerator;

	@Bean
	public Manager manager(){
		Manager manager = new Manager();
		UnderLinePen underLinePen = prototypeGenerator.underLinePen();
		underLinePen.setUlchar('~');
		manager.register("underLinePen", underLinePen);
		MessageBox warningBox = prototypeGenerator.messageBox();
		warningBox.setDecochar('/');
		manager.register("warningBox", underLinePen);
		MessageBox slashBox = prototypeGenerator.messageBox();
		slashBox.setDecochar('*');
		manager.register("slashBox", slashBox);
		return manager;
	}
}
