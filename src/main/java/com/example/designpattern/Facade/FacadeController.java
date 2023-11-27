package com.example.designpattern.Facade;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

@Controller
public class FacadeController {

	@Resource
	private PageMaker pageMaker;

	@GetMapping("/facade")
	public String facade(){
		pageMaker.makeWelcomePage("hyuki@hyuki.com", "maildata", "hello");
		return "hello";
	}
}
