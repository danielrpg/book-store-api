package com.daniel.bookstore.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_book")
    private Long id;

    private String title;
    private String author;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "author_book",
            joinColumns = @JoinColumn(name = "id_book", referencedColumnName = "id_book"),
            inverseJoinColumns = @JoinColumn(name = "id_author", referencedColumnName = "id_author"))
    private List<Author> authorList;

    public Book() {
    }

    public Book(Long id, String title, String author, List<Author> authorList) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.authorList = authorList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }
}