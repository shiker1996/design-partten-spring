package com.example.designpattern.Command;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public abstract class CommandGenerator {

	@Lookup
	protected abstract LightOnCommand lightOnCommand();

	@Lookup
	protected abstract LightOffCommand lightOffCommand();

	public LightOnCommand genLightOnCommand(LightReceiver lightReceiver){
		LightOnCommand lightOnCommand = lightOnCommand();
		lightOnCommand.setLightReceiver(lightReceiver);
		return lightOnCommand;
	}

	public LightOffCommand genLightOffCommand(LightReceiver lightReceiver){
		LightOffCommand lightOffCommand = lightOffCommand();
		lightOffCommand.setLightReceiver(lightReceiver);
		return lightOffCommand;
	}
}
