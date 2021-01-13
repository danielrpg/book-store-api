package com.daniel.bookstore.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_author")
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private Date dateOfBirth;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "author_book",
            joinColumns = @JoinColumn(name = "id_author", referencedColumnName = "id_author"),
            inverseJoinColumns = @JoinColumn(name = "id_book", referencedColumnName = "id_book"))
    private List<Book> bookList;

    public Author() {
    }

    public Author(Long id, String firstName, String lastName, String email, Date dateOfBirth, List<Book> bookList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.bookList = bookList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
