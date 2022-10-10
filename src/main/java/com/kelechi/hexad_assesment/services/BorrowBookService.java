package com.kelechi.hexad_assesment.services;

import com.kelechi.hexad_assesment.models.Book;

import java.util.Arrays;
import java.util.List;

public interface BorrowBookService {
    List<Book> borrow(Long id);

    List<Book> getBorrowedBooks();

    Book findById(long bookId);

    void remove(Book borrowed);
}
