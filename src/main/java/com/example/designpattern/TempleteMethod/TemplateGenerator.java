package com.example.designpattern.TempleteMethod;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public abstract class TemplateGenerator {

	@Lookup
	protected abstract CharItemDisplay charDisplay();

	@Lookup
	protected abstract StringItemDisplay stringDisplay();

	public CharItemDisplay genCharDisplay(char ch){
		CharItemDisplay charItemDisplay = charDisplay();
		charItemDisplay.initDisplay(ch);
		return charItemDisplay;
	}

	public StringItemDisplay genStringDisplay(String string){
		StringItemDisplay stringItemDisplay = stringDisplay();
		stringItemDisplay.initDisplay(string);
		return stringItemDisplay;
	}
}
