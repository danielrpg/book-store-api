package com.daniel.bookstore.services;

import com.daniel.bookstore.models.Author;
import com.daniel.bookstore.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return (List<Author>) authorRepository.findAll();
    }

    public Optional<Author> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    public void saveAuthor(Author author) {
        authorRepository.save(author);
    }
}
