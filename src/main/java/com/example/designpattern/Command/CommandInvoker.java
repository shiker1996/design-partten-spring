package com.example.designpattern.Command;

import java.util.Stack;

public class CommandInvoker {
	static Stack<Command> commands = new Stack<>();

	public static void setCommand(Command command) {
		commands.add(command);
	}

	public static void executeCommands(){
		for(Command command: commands){
			command.execute();
		}
	}

	public static void clearCommands(){
		commands.clear();
	}

	public static void undoCommand(){
		if(!commands.empty()) {
			Command command = commands.pop();
			command.undo();
		}
	}
}