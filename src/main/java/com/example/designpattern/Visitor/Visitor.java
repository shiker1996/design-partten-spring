package com.example.designpattern.Visitor;
/**
 * 表示访问者的抽象类，访问文件和文件夹
 * @author shiker96
 *
 */
public abstract class Visitor {
	public abstract void visit(VFile VFile);
	public abstract void visit(VDirectory VDirectory);
}
