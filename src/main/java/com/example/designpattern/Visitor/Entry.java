package com.example.designpattern.Visitor;
/**
 * 抽象类，是文件和文件夹的父类
 * @author shiker96
 */
public abstract class Entry implements Element {

	public abstract String getName();
	public abstract int getSize();
	public Entry add(Entry entry)throws FileTreatmentException{
		throw new FileTreatmentException();
	}
	public String toString(){
		return getName()+" ("+getSize()+")";
	}
}
