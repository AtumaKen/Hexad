package com.kelechi.hexad_assesment.services;

import com.kelechi.hexad_assesment.models.Book;

import java.util.List;

public interface BookService {

    List<Book> getAll();

    void addBook(Book book);

    boolean compareBooks(Book book1, Book book2);

    Book findById(Long id);

    void removeBook(Book id);
}
