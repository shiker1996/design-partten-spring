package com.example.designpattern.Composite;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class CompositeController {

	@Resource
	private EntryGenerator entryGenerator;

	@GetMapping("/composite")
	public String composite(){
		try {
			log.info("Making root entries...");
			Directory rootdir = entryGenerator.generateDir("root");
			Directory bindir = entryGenerator.generateDir("bin");
			Directory tmpir = entryGenerator.generateDir("tmp");
			Directory usrdir = entryGenerator.generateDir("usr");
			rootdir.add(bindir);
			rootdir.add(tmpir);
			rootdir.add(usrdir);
			bindir.add(entryGenerator.generateFile("vi", 10000));
			bindir.add(entryGenerator.generateFile("latex", 20000));
			rootdir.printList();

			log.info("Making user entries...");
			Directory yuki = entryGenerator.generateDir("yuki");
			Directory hanako = entryGenerator.generateDir("hanako");
			Directory tomura = entryGenerator.generateDir("tomura");
			usrdir.add(yuki);
			usrdir.add(hanako);
			usrdir.add(tomura);
			yuki.add(entryGenerator.generateFile("diary.html", 100));
			yuki.add(entryGenerator.generateFile("Composite.java", 200));
			hanako.add(entryGenerator.generateFile("memo.tex", 300));
			tomura.add(entryGenerator.generateFile("game.doc", 400));
			tomura.add(entryGenerator.generateFile("junk.mail", 500));
			rootdir.printList();
		} catch (FileTreatmentException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "success";
	}
}
