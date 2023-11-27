package com.example.designpattern.AbstractFactory.factory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

/**
 * 表示html页面的类
 *
 * @author shiker96
 */
@Slf4j
public abstract class Page {

	protected String title;
	protected String author;
	protected ArrayList<Item> content = new ArrayList<>();

	public void build(String title, String author) {
		this.title = title;
		this.author = author;
	}

	public void add(Item item) {
		content.add(item);
	}

	public void output() {
		try {
			File file = ResourceUtils.getFile("classpath:templates/" + title + ".html");
			Writer writer = new FileWriter(file);
			writer.write(this.makeHTML());
			writer.close();
			log.info(file.getName() + "编写完成");
		} catch (IOException e) {
			log.error("编写异常", e);
		}
	}

	public abstract String makeHTML();
}
