package com.example.designpattern.factoryMethod;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public abstract class IDCardGenerator {

	@Lookup
	public abstract IDcard iDcard();
}
