package com.example.designpattern.State;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class StateController {

	@Resource
	private SafeFrame frame;

	@GetMapping("state")
	public String state() {
		for (int hour = 0; hour < 24; hour++) {
			frame.setClock(hour);
			if(hour%3 == 0) {
				frame.actionPerformed("buttonUse");
			}
			if(hour%5 == 0){
				frame.actionPerformed("buttonPhone");
			}
			if(hour%4 == 0){
				frame.actionPerformed("buttonAlarm");
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

			}
		}
		return "SUCCESS";
	}
}
