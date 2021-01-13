package com.daniel.bookstore.controllers;

import com.daniel.bookstore.models.Book;
import com.daniel.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookController {

    @Autowired
    BookService bookService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/books/")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }


    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id") Long id) {
        return bookService.getBookById(id).get();
    }

    @PostMapping("/books/")
    public HttpStatus addBook(@RequestBody Book book){
        bookService.saveBook(book);
        return HttpStatus.CREATED;
    }
}
