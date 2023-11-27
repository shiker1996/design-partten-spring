package com.example.designpattern.Bridge;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BridgeController {

	@Resource
	Display display;
	@Resource
	CountDisplay countDisplay;

	@GetMapping("/bridge")
	public String bridge(){
		display.setImpl("Hello,China!");
		display.display();
		display.setImpl("Hello,World.");
		display.display();
		countDisplay.setImpl("Hello,Universe.");
		countDisplay.display();
		countDisplay.mutiDIsplay(5);
		return "success";
	}
}
