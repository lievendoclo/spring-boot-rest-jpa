package com.atomist.rest;

import com.atomist.domain.Book;
import com.atomist.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookResource {
    private final BookService bookService;

    public BookResource(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book")
    public List<BookJson> getBooks() {
        return bookService.getBooks().stream()
                .map(b -> {
                    BookJson json = new BookJson();
                    json.setId(b.getId());
                    json.setName(b.getName());
                    return json;
                }).collect(Collectors.toList());
    }

    @PostMapping("/book")
    public void createBook(@RequestBody BookJson book) {
        bookService.saveBook(new Book(null, book.getName()));
    }
}
