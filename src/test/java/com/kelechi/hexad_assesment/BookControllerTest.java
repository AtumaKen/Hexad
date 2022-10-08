package com.kelechi.hexad_assesment;

import com.kelechi.hexad_assesment.models.Book;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest
public class BookControllerTest {

    @Test
    void getAllBooks(){
        List<Book> books = new ArrayList<>();
        books.add(new Book(1L, "Harry Potter", "JK Rowlings"));
        books.add(new Book(2L, "Animal Farm", "George Owel"));
    }
}
