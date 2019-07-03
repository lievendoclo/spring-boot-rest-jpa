package com.atomist.service;

import com.atomist.domain.Book;

import java.util.List;

public interface BookService {
	void saveBook(Book book);
	List<Book> getBooks();
}
