package com.example.designpattern.Prototype;


import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public abstract class PrototypeGenerator {


	@Lookup
	public abstract MessageBox messageBox();

	@Lookup
	public abstract UnderLinePen underLinePen();


}
