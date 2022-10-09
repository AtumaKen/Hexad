package com.kelechi.hexad_assesment.services;

import com.kelechi.hexad_assesment.HeadAssessmentApplication;
import com.kelechi.hexad_assesment.exceptions.ProcessingException;
import com.kelechi.hexad_assesment.models.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = HeadAssessmentApplication.class)
class BorrowBookServiceTest {

    @Autowired
    private BorrowBookService service;

    @Autowired
    private BookService bookService;

    @Test
    void libraryIsNotEmptyBeforeBorrowing(){

        bookService.getAll().clear();
        assertThrows(ProcessingException.class, ()-> service.borrow(1L));

    }

    @Test
    void bookLeavesTheLibraryWhenBorrowed(){
        Book book1 = new Book(1L, "Harry Potter", "JK Rowlings", 1);
        Book book2  = new Book(2L, "Animal Farm", "George Owel", 1);

        List<Book> books = new ArrayList<>(List.of(book1, book2));
        Book borrowedBook = books.get(0);
        List<Book> available = service.borrow(borrowedBook.getId());
        assertFalse(available.stream().anyMatch(availableBook -> bookService.compareBooks(availableBook, borrowedBook)));
    }

    @Test
    void borrowedGoesIntoTheBorrowedList(){
        List<Book> all = bookService.getAll();
        Book borrowedBook = all.get(0);
        service.borrow(borrowedBook.getId());
        assertTrue(service.getBorrowedBooks().stream().anyMatch(borrowed -> bookService.compareBooks(borrowed, borrowedBook)));
    }

    @Test
    void userHasABorrowingLimitOfTwoBooks (){
        Book book1 = new Book(28L, "Harry Potter", "JK Rowlings", 1);
        Book book2  = new Book(98L, "Animal Farm", "George Owel", 1);
        bookService.addBook(book1);
        bookService.addBook(book2);
        service.borrow(98L);
        service.borrow(28L);
        assertThrows( ProcessingException.class, () -> service.borrow(1L), "User has a borrowing limit of 2");
    }

    @Test
    void userCanOnlyHaveOneCopyOfABook(){
        bookService.getAll().clear();
        bookService.addBook(new Book(28L, "Harry Potter", "JK Rowlings", 2));
        List<Book> allBooks = bookService.getAll();
        service.borrow(1L);
        assertEquals(1, bookService.findById(1L).getAvailableCopies());
    }

}