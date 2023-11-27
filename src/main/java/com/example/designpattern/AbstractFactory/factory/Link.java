package com.example.designpattern.AbstractFactory.factory;
/**
 * 表示含有link的类
 * @author shiker96
 *
 */

public abstract class Link extends Item {

	protected String url;

	public void build(String caption, String url){
		setCaption(caption);
		this.url = url;
	}

	public abstract String makeHTML();

}
