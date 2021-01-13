package com.daniel.bookstore.controllers;

import com.daniel.bookstore.models.Author;
import com.daniel.bookstore.models.Book;
import com.daniel.bookstore.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1")
public class AuthorController {

    final
    AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors/")
    public List<Author> getAllBooks() {
        return authorService.getAllAuthors();
    }


    @GetMapping("/authors/{id}")
    public Author getBook(@PathVariable("id") Long id) {
        return authorService.getAuthorById(id).get();
    }

    @PostMapping("/authors/")
    public HttpStatus addBook(@RequestBody Author author){
        authorService.saveAuthor(author);
        return HttpStatus.CREATED;
    }
}
