package com.example.designpattern.Interpreter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@RestController
@Slf4j
public class InterpreterController {

	@Resource
	private NodeGenerator nodeGenerator;

	@GetMapping("interceptor")
	public String interceptor() throws IOException, ParseException {
		File file = ResourceUtils.getFile("classpath:templates/Program.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String text;
		while ((text = reader.readLine()) != null) {
			log.info("text=\"" + text + "\"");
			Node node = nodeGenerator.programNode();
			node.parse(nodeGenerator.genContext(text));
			log.info("node = " + node);
		}
		reader.close();
		return "success";
	}
}
