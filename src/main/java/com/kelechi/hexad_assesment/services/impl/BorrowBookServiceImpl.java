package com.kelechi.hexad_assesment.services.impl;

import com.kelechi.hexad_assesment.models.Book;
import com.kelechi.hexad_assesment.services.BookService;
import com.kelechi.hexad_assesment.services.BorrowBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BorrowBookServiceImpl implements BorrowBookService {

    private final BookService bookService;

    @Override
    public List<Book> borrow(Long id) {
        Book bookToBeBorrowed = bookService.findById(id);
        bookService.removeBook(bookToBeBorrowed);

        return bookService.getAll();
    }
}
