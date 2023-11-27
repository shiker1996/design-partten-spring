package com.example.designpattern.Interpreter;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public abstract class NodeGenerator {

	@Lookup
	public abstract CommandListNode commandListNode();

	@Lookup
	public abstract CommandNode commandNode();

	@Lookup
	public abstract RepeatCommandNode repeatCommandNode();

	@Lookup
	public abstract PrimitiveCommandNode primitiveCommandNode();

	@Lookup
	public abstract ProgramNode programNode();

	@Lookup
	protected abstract Context context();

	public Context genContext(String text){
		Context context = context();
		context.initContext(text);
		return context;
	}
}
