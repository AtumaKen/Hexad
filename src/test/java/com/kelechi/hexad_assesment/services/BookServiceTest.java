package com.kelechi.hexad_assesment.services;

import com.kelechi.hexad_assesment.HeadAssessmentApplication;
import com.kelechi.hexad_assesment.models.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


@SpringBootTest(classes = HeadAssessmentApplication.class)
public class BookServiceTest {

    @Autowired
    private BookService service;

    @Test
    void findAllBooks(){

        Book book1 = new Book(1L, "Harry Potter", "JK Rowlings");
        Book book2  = new Book(2L, "Animal Farm", "George Owel");


        service.addBook(book1);
        service.addBook(book2);
        List<Book> allBooks = service.getAll();

        Book lastBook = allBooks.get(allBooks.size() - 1);
        assertEquals(book2.getId(), lastBook.getId());
        assertEquals(book2.getTitle(), lastBook.getTitle());
        assertEquals(book2.getAuthor(), lastBook.getAuthor());
    }

    @Test
    void libraryIsNotEmptyAfterAddingBook(){
        Book book1 = new Book(1L, "Harry Potter", "JK Rowlings");
        service.addBook(book1);
        assertFalse(service.getAll().isEmpty());
    }







}
