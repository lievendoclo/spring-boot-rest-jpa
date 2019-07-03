package com.atomist.persistence;

import com.atomist.domain.Book;

import java.util.List;

public interface BookRepository {
	void saveBook(Book book);
	List<Book> getBooks();
}
