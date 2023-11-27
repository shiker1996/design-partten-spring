package com.example.designpattern.Command;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class CommandController {

	@Resource
	private LightReceiver lightReceiver;
	@Resource
	private CommandGenerator commandGenerator;

	@GetMapping("command")
	public boolean command(){
		CommandInvoker.setCommand(commandGenerator.genLightOnCommand(lightReceiver));
		CommandInvoker.setCommand(commandGenerator.genLightOffCommand(lightReceiver));
		CommandInvoker.executeCommands();
		CommandInvoker.undoCommand();
		CommandInvoker.undoCommand();
		return lightReceiver.isStatus();
	}
}
