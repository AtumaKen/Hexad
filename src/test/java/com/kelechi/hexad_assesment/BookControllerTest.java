package com.kelechi.hexad_assesment;

import com.kelechi.hexad_assesment.models.Book;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest
public class BookControllerTest {

    @MockBean
    private BookService bookService;

    @Test
    void getAllBooks(){
        List<Book> books = new ArrayList<>();
        books.add(new Book(1L, "Harry Potter", "JK Rowlings"));
        books.add(new Book(2L, "Animal Farm", "George Owel"));

        when(bookService.findAll()).thenReturn(books);
    }
}
