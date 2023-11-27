package com.example.designpattern.Builder;

import com.example.designpattern.Builder.framework.Builder;
import com.example.designpattern.Builder.framework.Director;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BuilderController {


	@Resource
	private BuilderGenerator builderGenerator;
	@Resource
	private Director director;

	/**
	 *  textBuilder 编写纯文本文档
	 *  HTMLBuilder 编写HTML文档
	 * @param builderName
	 * @return
	 */
	@GetMapping("builder")
	public String builder(String builderName){
		Builder builder = builderGenerator.getBuilder(builderName);
		director.setBuilder(builder);
		director.construct();
		return builder.getResult();
	}
}
