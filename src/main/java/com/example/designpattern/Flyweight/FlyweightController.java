package com.example.designpattern.Flyweight;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class FlyweightController {

	@Resource
	private BigString bigString;

	@GetMapping("/flyweight")
	public String flyweight(String param){
		bigString.initBigString(param);
		bigString.print();
		return "success";
	}
}
