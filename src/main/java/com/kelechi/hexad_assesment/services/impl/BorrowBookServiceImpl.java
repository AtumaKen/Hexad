package com.kelechi.hexad_assesment.services.impl;

import com.kelechi.hexad_assesment.exceptions.ProcessingException;
import com.kelechi.hexad_assesment.models.Book;
import com.kelechi.hexad_assesment.services.BookService;
import com.kelechi.hexad_assesment.services.BorrowBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BorrowBookServiceImpl implements BorrowBookService {

    private final BookService bookService;

    private final List<Book> borrowedBooks = new ArrayList<>();

    @Override
    public List<Book> borrow(Long id) {
        System.out.println("borrowed list " + borrowedBooks.size());
        if(borrowedBooks.size() > 1 )
            throw new ProcessingException("Borrow Limit exceeded");
        Book bookToBeBorrowed = bookService.findById(id);
        bookService.removeBook(bookToBeBorrowed);
        borrowedBooks.add(bookToBeBorrowed);
        return bookService.getAll();
    }

    @Override
    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
}
