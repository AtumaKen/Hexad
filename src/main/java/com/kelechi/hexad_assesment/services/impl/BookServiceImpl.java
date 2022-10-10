package com.kelechi.hexad_assesment.services.impl;

import com.kelechi.hexad_assesment.exceptions.ProcessingException;
import com.kelechi.hexad_assesment.models.Book;
import com.kelechi.hexad_assesment.services.BookService;
import com.kelechi.hexad_assesment.services.BorrowBookService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BorrowBookService borrowBookService;

    private final List<Book> books = new ArrayList<>();

    public BookServiceImpl(@Lazy BorrowBookService borrowBookService) {
        this.borrowBookService = borrowBookService;
    }

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
                .orElseThrow(() -> new ProcessingException("Book not found"));
    }

    //todo: refactor
    @Override
    public void removeBook(Book book) {
        books.remove(book);
    }

    @Override
    public Book borrowBook(Book book) {
        Book toBeBorrowed = findById(book.getId());
        if (toBeBorrowed.getAvailableCopies() > 0) {
            toBeBorrowed.setAvailableCopies(toBeBorrowed.getAvailableCopies() - 1);
            if (toBeBorrowed.getAvailableCopies() == 0)
                removeBook(toBeBorrowed);
            return toBeBorrowed;
        }
        removeBook(toBeBorrowed);
        return toBeBorrowed;
    }

    @Override
    public Book returnBook(Book book) {
        List<Book> borrowedBooks = borrowBookService.getBorrowedBooks();
        //todo: check for empty borrowed book list
        Book borrowed = borrowedBooks.stream().filter(book1 -> compareBooks(book1, book)).findAny()
                .orElseThrow(() -> new ProcessingException("Book not in borrowed list"));
        borrowBookService.remove(borrowed);
        Optional<Book> any = books.stream().filter(book1 -> compareBooks(book1, borrowed)).findAny();
        if (any.isPresent()) {
            Book returnedBook = any.get();
            returnedBook.setAvailableCopies(returnedBook.getAvailableCopies() + 1);
        } else books.add(book);
        return book;
    }


}
