package com.example.designpattern.Singleton;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class SingletonController {

	@Resource
	Singleton singleton;
	@Resource
	Singleton singleton2;

	@GetMapping("singleton")
	public Boolean singleton(){
		System.out.println("start.");
		if(singleton == singleton2){
			log.info("obj1与obj2是相同的实例");
			return true;
		}else{
			log.error("obj1与obj2不是相同的实例");
			return false;
		}
	}
}
