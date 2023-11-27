package com.example.designpattern.Decorator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class DecoratorController {

	@Resource
	DisplayGenerator displayGenerator;

	@GetMapping("decorate")
	public String decorate(){
		Display b1 = displayGenerator.getStringDisplay("hello, world.");
		Display b2 = displayGenerator.getSideBorder(b1, '#');
		Display b3 = displayGenerator.getFullBorder(b2);
		b1.show();
		b2.show();
		b3.show();
		Display b4 = displayGenerator.getSideBorder(displayGenerator.getFullBorder(
				displayGenerator.getFullBorder(displayGenerator.getSideBorder(displayGenerator.getFullBorder(displayGenerator.getStringDisplay(
						"你好，世界")), '*'))), '/');
		b4.show();
		return "success";
	}
}
