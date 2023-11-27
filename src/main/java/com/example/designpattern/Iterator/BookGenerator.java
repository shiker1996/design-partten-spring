package com.example.designpattern.Iterator;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public abstract class BookGenerator {

	@Lookup
	protected abstract Book book();

	public Book genBooK(String name){
		Book book = book();
		book.setName(name);
		return book;
	}
}
