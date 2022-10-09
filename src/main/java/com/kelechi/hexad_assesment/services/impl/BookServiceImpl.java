package com.kelechi.hexad_assesment.services.impl;

import com.kelechi.hexad_assesment.exceptions.ProcessingException;
import com.kelechi.hexad_assesment.models.Book;
import com.kelechi.hexad_assesment.services.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final List<Book> books = new ArrayList<>();

    @Override
    public List<Book> getAll() {
        return books;
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public boolean compareBooks(Book book1, Book book2) {
        return book1.getAuthor().equals(book2.getAuthor())
                && book1.getTitle().equals(book2.getTitle())
                && book1.getId().equals(book2.getId());
    }



    @Override
    public Book findById(Long id) {
        return books.stream().filter(book -> book.getId().equals(id)).findAny()
                .orElseThrow( () ->new ProcessingException("Book not found"));
    }

    @Override
    public void removeBook(Book book) {
        books.remove(book);
    }

    @Override
    public Book borrowBook(Book book) {
        Book toBeBorrowed = findById(book.getId());
        if(toBeBorrowed.getAvailableCopies() > 0) {
            toBeBorrowed.setAvailableCopies(toBeBorrowed.getAvailableCopies() - 1);

            return toBeBorrowed;
        }
        removeBook(toBeBorrowed);
        return toBeBorrowed;
    }


}
