package com.example.designpattern.Compartor;

public class Main {
	public static void main(String[] args) {
		Apple a = new Apple(60, 550);
		Apple b = new Apple(70, 550);
		MyCompator com = new MyCompator();
		System.out.println("调用内部比较器"+a.compareTo(b));
		System.out.println("调用外部比较器"+com.compact(a, b));
		if(a.compareTo(b)<0&&com.compact(a, b)<0 ){
			System.out.println("两者比较结果相同");
		}
		if(a.equals(b)&&com.equals(a, b)) System.out.println("两者相同");
		else System.out.println("内部判断"+a.equals(b)+"外部判断"+com.equals(a, b));
	}
}
