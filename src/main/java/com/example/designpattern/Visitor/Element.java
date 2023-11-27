package com.example.designpattern.Visitor;
/**
 * 表示数据结构的接口，接受访问者的访问
 * @author shiker96
 *
 */
public interface Element {
	void accept(Visitor v);
}
