package com.kelechi.hexad_assesment.services;

import com.kelechi.hexad_assesment.HeadAssessmentApplication;
import com.kelechi.hexad_assesment.exceptions.ProcessingException;
import com.kelechi.hexad_assesment.models.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = HeadAssessmentApplication.class)
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Autowired
    private BorrowBookService borrowBookService;

    @BeforeEach
    public void setUp() {
        bookService.getAll().clear();
        borrowBookService.getBorrowedBooks().clear();
    }

    @Test
    void findAllBooks(){

        Book book1 = new Book(1L, "Harry Potter", "JK Rowlings", 1);
        Book book2  = new Book(2L, "Animal Farm", "George Owel", 1);


        bookService.addBook(book1);
        bookService.addBook(book2);
        List<Book> allBooks = bookService.getAll();

        Book lastBook = allBooks.get(allBooks.size() - 1);
        assertEquals(book2.getId(), lastBook.getId());
        assertEquals(book2.getTitle(), lastBook.getTitle());
        assertEquals(book2.getAuthor(), lastBook.getAuthor());
    }

    @Test
    void libraryIsNotEmptyAfterAddingBook(){
        Book book1 = new Book(1L, "Harry Potter", "JK Rowlings", 1);
        bookService.addBook(book1);
        assertFalse(bookService.getAll().isEmpty());
    }

    @Test
    void userCanReturnABookFromTheBorrowedList(){
        Book book1 = new Book(1L, "Harry Potter", "JK Rowlings", 1);
        Book book2  = new Book(2L, "Animal Farm", "George Owel", 1);
        bookService.addBook(book1);
        bookService.addBook(book2);
        borrowBookService.borrow(1L);
        borrowBookService.borrow(2L);
        bookService.returnBook(borrowBookService.findById(1L));
        List<Book> availableBooks = bookService.getAll();
        List<Book> borrowedBooks = borrowBookService.getBorrowedBooks();
        assertTrue(availableBooks.stream().anyMatch(available -> bookService.compareBooks(available, book1)));
        assertFalse(borrowedBooks.stream().anyMatch(borrowed -> bookService.compareBooks(borrowed, book1)));
    }

    @Test
    void userCanNotReturnABookWhenBorrowedListIsEmpty(){
        Book book2  = new Book(2L, "Animal Farm", "George Owel", 1);
        bookService.addBook(book2);
        assertThrows(ProcessingException.class, () -> bookService.returnBook(book2));
    }

    @Test
    void increamentAvailableCopiesWhenBookIsReturned(){
        Book book2  = new Book(2L, "Animal Farm", "George Owel", 1);
        bookService.addBook(book2);
        borrowBookService.borrow(2L);
        bookService.returnBook(book2);
        assertEquals(1, bookService.findById(2L).getAvailableCopies());
    }

}
