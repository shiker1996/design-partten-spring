package com.example.designpattern.TempleteMethod;

public abstract class AbstractDisplay {

	//子类要实现的抽象方法open
	public abstract void open();
	
	//交给子类去实现的抽象方法print
	public abstract void print();
	
	//交给子类去实现的抽象方法close
	public abstract void close();
	
	//本抽象类实现的display方法
	public final void display(){
		open();//先打开
		for(int i =0;i<5;i++){
			print();//循环打印
		}
		close();//关闭
	}
}
