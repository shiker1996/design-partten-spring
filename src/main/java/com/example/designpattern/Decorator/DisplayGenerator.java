package com.example.designpattern.Decorator;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public abstract class DisplayGenerator {

	@Lookup
	protected abstract StringDisplay stringDisplay();

	@Lookup
	protected abstract SideBorder sideBorder();

	@Lookup
	protected abstract FullBorder fullBorder();

	public Display getStringDisplay(String s){
		StringDisplay stringDisplay = stringDisplay();
		stringDisplay.initStringDisplay(s);
		return stringDisplay;
	}

	public Display getFullBorder(Display display){
		FullBorder fullBorder = fullBorder();
		fullBorder.initFullBorder(display);
		return fullBorder;
	}

	public Display getSideBorder(Display display, char c){
		SideBorder sideBorder = sideBorder();
		sideBorder.initSideBorder(display, c);
		return sideBorder;
	}
}
