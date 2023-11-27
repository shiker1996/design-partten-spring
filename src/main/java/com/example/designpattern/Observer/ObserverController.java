package com.example.designpattern.Observer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ObserverController {

	@Resource
	NumberGenerator numberGenerator;
	@Resource
	DigitObserver digitObserver;
	@Resource
	GraphObserver graphObserver;

	@GetMapping("observer")
	public String observer(){
		numberGenerator.addObserver(digitObserver);
		numberGenerator.addObserver(graphObserver);
		numberGenerator.execute();
		return "SUCCESS";
	}
}
