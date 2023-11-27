package com.example.designpattern.AbstractFactory.factory;

/**
 * 抽象工厂，制作link、tray、page
 * @author shiker96
 *
 */

public abstract class Factory {

	public String getName(){
		return this.getClass().getAnnotation(FactoryName.class).value();
	}

	public abstract Link createLink(String caption, String url);

	public abstract Tray createTray(String caption);

	public abstract Page createPage(String title, String author);
}