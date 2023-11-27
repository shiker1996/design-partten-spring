package com.example.designpattern.Interpreter;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;

@Component
public class CommandListNode extends Node {

	private ArrayList<Node> list = new ArrayList<Node>();
	private Node node;
	@Resource
	private NodeGenerator nodeGenerator;

	@Override
	public void parse(Context context) throws ParseException {
		// TODO Auto-generated method stub
		while(true){
			if(context.currentToken()==null){
				throw new ParseException("Missing 'end");
			}else if(context.currentToken().equals("end")){
				context.skipToken("end");
				break;
			}else{
				node = nodeGenerator.commandNode();
				node.parse(context);
				list.add(node);
			}
		}
	}

	@Override
	public String toString() {
		return list.toString();
	}

}
