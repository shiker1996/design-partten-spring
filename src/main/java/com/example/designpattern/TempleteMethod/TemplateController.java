package com.example.designpattern.TempleteMethod;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TemplateController {

	@Resource
	private TemplateGenerator templateGenerator;

	@GetMapping("template")
	public String template(){
		AbstractDisplay d1 = templateGenerator.genCharDisplay('H');
		AbstractDisplay d2 = templateGenerator.genStringDisplay("hello world");
		AbstractDisplay d3 = templateGenerator.genStringDisplay("世界你好");
		d1.display();
		d2.display();
		d3.display();
		return "SUCCESS";
	}
}
