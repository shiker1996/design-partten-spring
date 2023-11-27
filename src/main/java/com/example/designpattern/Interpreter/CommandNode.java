package com.example.designpattern.Interpreter;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class CommandNode extends Node {

	private Node node;
	@Resource
	private NodeGenerator nodeGenerator;
	
	@Override
	public void parse(Context context) throws ParseException {
		// TODO Auto-generated method stub
		if(context.currentToken().equals("repeat")){
			node = nodeGenerator.repeatCommandNode();
			node.parse(context);
		}else{
			node = nodeGenerator.primitiveCommandNode();
			node.parse(context);
		}
	}

	@Override
	public String toString() {
		return "[" + node + "]";
	}

}
