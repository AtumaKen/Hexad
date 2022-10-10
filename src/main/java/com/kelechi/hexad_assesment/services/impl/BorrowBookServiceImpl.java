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
        if(borrowedBooks.size() > 1 )
            throw new ProcessingException("Borrow Limit exceeded");
        Book bookToBeBorrowed = bookService.findById(id);

        Book book = bookService.borrowBook(bookToBeBorrowed);
        if(borrowedBooks.stream().anyMatch(book1 -> bookService.compareBooks(book1, book)))
            throw new ProcessingException("You can only have one copy of this book");

        borrowedBooks.add(book);
        return bookService.getAll();
    }

    @Override
    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    @Override
    public Book findById(long bookId) {
        return borrowedBooks.stream().filter(book -> book.getId().equals(bookId)).findAny()
                .orElseThrow( () ->new ProcessingException("Book not in borrowed List"));
    }

    @Override
    public void remove(Book borrowed) {
        borrowedBooks.remove(borrowed);
    }
}
