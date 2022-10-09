package com.kelechi.hexad_assesment.services.impl;

import com.kelechi.hexad_assesment.models.Book;
import com.kelechi.hexad_assesment.services.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private List<Book> books = new ArrayList<>();

    @Override
    public List<Book> findAll() {
        return books;
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }


}
