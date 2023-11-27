package com.example.designpattern.Interpreter;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ProgramNode extends Node {

	private Node node;
	@Resource
	private NodeGenerator nodeGenerator;

	@Override
	public void parse(Context context) throws ParseException {
		// TODO Auto-generated method stub
		context.skipToken("program");
		node = nodeGenerator.commandListNode();
		node.parse(context);
	}

	@Override
	public String toString() {
		return "Program[" + node + "]";
	}
}
