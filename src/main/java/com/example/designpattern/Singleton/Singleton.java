package com.example.designpattern.Singleton;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Singleton {
	Singleton(){
		log.info("生成了一个实例");
	}
	//没有判断该对象是否为null，为饿汉式
}
