package com.atomist.service;

import com.atomist.domain.Book;
import com.atomist.persistence.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
	private final BookRepository bookRepository;

	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public void saveBook(Book book) {
		this.bookRepository.saveBook(book);
	}

	@Override
	public List<Book> getBooks() {
		return this.bookRepository.getBooks();
	}
}
