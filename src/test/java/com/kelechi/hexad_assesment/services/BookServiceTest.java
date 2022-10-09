package com.kelechi.hexad_assesment.services;

import com.kelechi.hexad_assesment.models.Book;
import com.kelechi.hexad_assesment.services.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BookServiceTest {

    @Test
    void findAll(){
        BookService service = new BookServiceImpl();
        service.findAll();
    }
}
