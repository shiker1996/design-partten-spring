package com.example.designpattern.Builder.framework;
/**
 * 声明了编写文档的方法
 * @author shiker96
 *
 */
public interface Builder {

	void makeTitle(String title);

	void makeString(String str);

	void makeItems(String[] items);

	void close();

	String getResult();
}
