package com.example.designpattern.Iterator;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * 书架
 * @author shiker96
 *
 */
@Component
public class BookShelf implements Aggregate {

	private ArrayList<Book> books;
	private int last = 0;
	@Resource
	private BookShelfIterator bookShelfIterator;

	public void initBookShelf(int maxsize) {
		this.books = new ArrayList<Book>(maxsize);
	}
	public Book getBookAt(int index){
		return books.get(index);
	}
	public void appendBook(Book book){
		this.books.add(book);
		last++;
	}
	
	public int getLength(){
		return last;
	}
	/**
	 * 创建迭代器
	 * @return 书架迭代器
	 */
	public Iterator getIterator(){
		bookShelfIterator.initBookShelfIterator(this);
		return bookShelfIterator;
	}
}
