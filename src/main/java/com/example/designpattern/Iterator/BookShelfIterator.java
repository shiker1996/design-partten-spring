package com.example.designpattern.Iterator;

import org.springframework.stereotype.Component;

/**
 * 遍历书架
 * @author shiker96
 *
 */
	@Component
	public class BookShelfIterator implements Iterator {
		private BookShelf bookShelf;
		private int index;

		public void initBookShelfIterator(BookShelf bookShelf) {
			this.bookShelf = bookShelf;
		    this.index = 0;
		}

		@Override
		public boolean hasNext() {
			if (index < bookShelf.getLength()) {
				return true;
			} else {
				return false;
			}
		}

		@Override
		public Object next() {
			Book book = bookShelf.getBookAt(index);
			index++;
			return book;
		}

	}
