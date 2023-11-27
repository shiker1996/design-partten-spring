package com.example.designpattern.AbstractFactory.tablefactory;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public abstract class TableGenerator {

	@Lookup
	public abstract TableLink tableLink();

	@Lookup
	public abstract TableTray tableTray();

	@Lookup
	public abstract TablePage tablePage();
}
