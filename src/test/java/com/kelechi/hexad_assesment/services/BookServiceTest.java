package com.kelechi.hexad_assesment.services;

import com.kelechi.hexad_assesment.models.Book;
import com.kelechi.hexad_assesment.services.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BookServiceTest {

    @Test
    void findAll(){

        Book book1 = new Book(1L, "Harry Potter", "JK Rowlings");
        Book book2  = new Book(2L, "Animal Farm", "George Owel");

        BookService service = new BookServiceImpl();
        service.add(book1);
        service.add(book2);
        List<Book> all = service.findAll();
    }


}
