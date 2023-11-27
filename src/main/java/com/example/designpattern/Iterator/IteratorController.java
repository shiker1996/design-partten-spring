package com.example.designpattern.Iterator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class IteratorController {

	@Resource
	private BookShelf bookShelf;
	@Resource
	private BookGenerator bookGenerator;

	@GetMapping("/iterator")
	public String iterator(){
		bookShelf.initBookShelf(4);
		bookShelf.appendBook(bookGenerator.genBooK("Around the world"));
		bookShelf.appendBook(bookGenerator.genBooK("hello world"));
		bookShelf.appendBook(bookGenerator.genBooK("hello kitty"));
		bookShelf.appendBook(bookGenerator.genBooK("little pig peqi"));
		Iterator it = bookShelf.getIterator();
		String result = "";
		while (it.hasNext()) {
			Book book = (Book) it.next();
			result += "书名：" + (book.getName()) +"\n";
		}
		return result;
	}
}
