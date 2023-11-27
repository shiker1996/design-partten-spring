package com.example.designpattern.AbstractFactory.listfactory;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public abstract class ListGenerator {

	@Lookup
	public abstract ListLink listLink();

	@Lookup
	public abstract ListPage listPage();

	@Lookup
	public abstract ListTray listTray();

}
