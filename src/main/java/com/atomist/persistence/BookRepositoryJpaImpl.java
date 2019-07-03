package com.atomist.persistence;

import com.atomist.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
public class BookRepositoryJpaImpl implements BookRepository {
	private final EntityManager entityManager;

	public BookRepositoryJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void saveBook(Book book) {
		BookEntity bookEntity = new BookEntity();
		bookEntity.setName(book.getName());
		entityManager.persist(bookEntity);
		entityManager.flush();
	}

	@Override
	public List<Book> getBooks() {
		TypedQuery<BookEntity> bookQuery = entityManager.createQuery("SELECT b FROM Book b", BookEntity.class);
		return bookQuery.getResultList().stream()
				.map(b -> new Book(b.getId(), b.getName()))
				.collect(Collectors.toList());
	}
}
