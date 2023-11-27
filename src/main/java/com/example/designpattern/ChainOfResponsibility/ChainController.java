package com.example.designpattern.ChainOfResponsibility;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ChainController {

	@Resource
	SupportGenerator supportGenerator;

	@GetMapping("chain")
	public String chain(){
		Support alice = supportGenerator.genNoSupport("Alice");
		Support bob = supportGenerator.genLimitSupport("Bob", 100);
		Support charlie = supportGenerator.genSpecialSupport("Charlie", 429);
		Support diana = supportGenerator.genLimitSupport("Diana", 200);
		Support elmo = supportGenerator.genOddSupport("Elmo");
		Support fred = supportGenerator.genLimitSupport("Fred", 300);
		alice.setNext(bob).setNext(charlie).setNext(diana).setNext(elmo).setNext(fred);
		for (int i = 0; i < 500; i+=33) {
			alice.support(new Trouble(i));
		}
		return "SUCCESS";
	}
}
