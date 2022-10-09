package com.kelechi.hexad_assesment.services;

import com.kelechi.hexad_assesment.models.Book;
import com.kelechi.hexad_assesment.services.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookServiceTest {

    @Test
    void findAllBooks(){

        Book book1 = new Book(1L, "Harry Potter", "JK Rowlings");
        Book book2  = new Book(2L, "Animal Farm", "George Owel");

        BookService service = new BookServiceImpl();
        service.addBook(book1);
        service.addBook(book2);
        List<Book> allBooks = service.findAll();

        Book lastBook = allBooks.get(allBooks.size() - 1);
        assertEquals(book2.getId(), lastBook.getId());
        assertEquals(book2.getTitle(), lastBook.getTitle());
        assertEquals(book2.getAuthor(), lastBook.getAuthor());
    }


}
