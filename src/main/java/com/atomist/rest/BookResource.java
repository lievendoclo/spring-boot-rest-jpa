package com.atomist.rest;

import com.atomist.domain.Book;
import com.atomist.service.BookService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@Path("/book")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {
    @Inject
    private BookService bookService;

    @GET
    public List<BookJson> getBooks() {
        return bookService.getBooks().stream()
                .map(b -> {
                    BookJson json = new BookJson();
                    json.setId(b.getId());
                    json.setName(b.getName());
                    return json;
                }).collect(Collectors.toList());
    }

    @POST
    public void createBook(BookJson book) {
        bookService.saveBook(new Book(null, book.getName()));
    }
}
