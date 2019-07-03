package com.atomist.service;

import com.atomist.domain.Book;
import com.atomist.persistence.BookRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class BookServiceImpl implements BookService {
	@Inject
	private BookRepository bookRepository;

	@Override
	public void saveBook(Book book) {
		this.bookRepository.saveBook(book);
	}

	@Override
	public List<Book> getBooks() {
		return this.bookRepository.getBooks();
	}
}
