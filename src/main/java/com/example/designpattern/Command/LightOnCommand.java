package com.example.designpattern.Command;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
public class LightOnCommand implements Command {

	private LightReceiver lightReceiver;

	@Override
	public void execute() {
		lightReceiver.on();
	}

	@Override
	public void undo() {
		lightReceiver.undo();
	}

	public void setLightReceiver(LightReceiver lightReceiver) {
		this.lightReceiver = lightReceiver;
	}
}
