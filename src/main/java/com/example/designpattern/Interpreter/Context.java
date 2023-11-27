package com.example.designpattern.Interpreter;

import org.springframework.stereotype.Component;

import java.util.StringTokenizer;

@Component
public class Context {
	private StringTokenizer tokenizer;
	private String currentToken;

	public void initContext(String text){
		tokenizer = new StringTokenizer(text);
		nextToken();
	}

	public String nextToken() {
		// TODO Auto-generated method stub
		if (tokenizer.hasMoreTokens()) {
			currentToken = tokenizer.nextToken();
		} else {
			currentToken = null;
		}
		return currentToken;
	}

	public String currentToken() {
		return currentToken;
	}

	public void skipToken(String token) throws ParseException {
		if (!token.equals(currentToken)) {
			throw new ParseException("Warning: " + token + "is excepted, but " + currentToken + "is found. ");
		}
		nextToken();
	}

	public int currentNumber() throws ParseException {
		int number = 0;
		try {
			number = Integer.parseInt(currentToken);
		} catch (NumberFormatException e) {
			throw new ParseException("Warning" + e);
		}
		return number;
	}
}
